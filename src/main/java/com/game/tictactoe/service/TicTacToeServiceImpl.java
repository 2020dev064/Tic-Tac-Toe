package com.game.tictactoe.service;

import com.game.tictactoe.model.GameStatus;
import com.game.tictactoe.util.TicTacToeConstants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * All the tic tac toe services are implemented here
 *
 * @Author 2020-DEV-064
 */
@Getter
@Setter
@Service
public class TicTacToeServiceImpl implements TicTacToeService {

    @Autowired
    private GameStatus gameStatus;

    private char[][] playField;
    private int playerCounter;

    public TicTacToeServiceImpl() {
        this.playField  = TicTacToeConstants.START_GAME_PLAY_FIELD;
        this.playerCounter = 0;
    }

    /**
     * playerTurn method will determine if player one or player two is playing and draw an X or an O on the play field
     */
    public void playerTurn(int row, int column) {
        if (playerCounter % 2 == 0) {
            playField[row][column] = TicTacToeConstants.PLAYER_ONE_X;
        } else {
            playField[row][column] = TicTacToeConstants.PLAYER_TWO_O;
        }
        gameStatus.setPlayField(this.playField);
        playerCounter++;
    }
}
