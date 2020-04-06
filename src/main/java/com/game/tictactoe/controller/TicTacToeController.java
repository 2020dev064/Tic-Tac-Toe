package com.game.tictactoe.controller;

import com.game.tictactoe.exceptions.InputInUseException;
import com.game.tictactoe.exceptions.NumberNotInRangeException;
import com.game.tictactoe.model.GameStatus;
import com.game.tictactoe.service.TicTacToeService;
import com.game.tictactoe.util.TicTacToeConstants;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The class will be controlling the data between the service and the view
 *
 * @Author 2020-DEV-064
 */
@Setter
@Controller
public class TicTacToeController {

    @Autowired
    private GameStatus gameStatus;

    @Autowired
    private TicTacToeService ticTacToeService;

    private String htmlTemplate = "tictactoe";

    /**
     * This method will print the game layout of the start page
     * The key value playfield and TicTacToe constant is used in the index.html by thymeleaf
     */
    @RequestMapping(value = "/start")
    public String printGameLayout(Model model){
        model.addAttribute("playField", TicTacToeConstants.START_GAME_PLAY_FIELD);
        return htmlTemplate;
    }

    /**
     * This method checks if the input is valid, then calls the playerTurn method that will draw an 'X' or 'O'
     *  and update the play field of gameStatus object
     */
    @RequestMapping(value = "/playingGame")
    public String playGame(Model model,
                           @RequestParam(value = "row", required = false) String row,
                           @RequestParam(value = "column", required = false) String column){
        try {
            int validRowNumber = numberFormat(row);
            int validColumnNumber = numberFormat(column);

            numberNotInRange(validRowNumber);
            numberNotInRange(validColumnNumber);

            inputInUSe(validRowNumber, validColumnNumber, gameStatus.getPlayField());

            ticTacToeService.playerTurn(validRowNumber, validColumnNumber);

        } catch (NumberFormatException | NumberNotInRangeException | InputInUseException exception){
            model.addAttribute("exceptionMessage", exception.getMessage());
        } finally{
            model.addAttribute("playField", gameStatus.getPlayField());
            return htmlTemplate;
        }
    }

    /**
     * Method throws an exception when number is smaller then 1 or bigger than 3
     */
    public void numberNotInRange(int number) throws NumberNotInRangeException {
        if (number < 1 || number > 3) {
            throw new NumberNotInRangeException(TicTacToeConstants.NUMBER_NOT_IN_RANGE_EXCEPTION_MESSAGE);
        }
    }

    /**
     * Method throws an exception when given field is already in use
     */
    public void inputInUSe(int row, int column, char[][] temporaryPlayField) throws InputInUseException {
        if (temporaryPlayField[row][column] == TicTacToeConstants.PLAYER_ONE_X
                || temporaryPlayField[row][column] == TicTacToeConstants.PLAYER_TWO_O) {
            throw new InputInUseException(TicTacToeConstants.INPUT_IN_USE_EXCEPTION_MESSAGE);
        }
    }

    /**
     * Method throws a NumberFormatException if given string is not a Integer value
     */
    public int numberFormat (String toParse) throws NumberFormatException{
        try{
            return Integer.parseInt(toParse);
        } catch (NumberFormatException nfe){
            throw new NumberFormatException(toParse +
                    TicTacToeConstants.NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
