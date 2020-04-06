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

    /**
     * If playerPoints equals three that means three in a row so return true
     */
    public boolean playerWon(int playerPoints) {
        if (playerPoints == 3) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method that checks three in a row horizontal
     * The row that will be checked is the row where the last X or O is drawn
     */
    public boolean horizontalCheck(char[][] playField, char player, int row) {
        int playerCounter = 0;
        for (int i = 1; i < playField[row].length; i++) {
            if (playField[row][i] == player) {
                playerCounter += 1;
            }
        }
        return playerWon(playerCounter);
    }

    /**
     * Method that checks three in a row vertical
     * The column that will be checked is the column where the last X or O is drawn
     */
    public boolean verticalCheck(char[][] playField, char player, int column) {
        int playerCounter = 0;
        for (int i = 1; i < playField[column].length; i++) {
            if (playField[i][column] == player) {
                playerCounter += 1;
            }
        }
        return playerWon(playerCounter);
    }

    /**
     * Method checks three of the same X or O from upper left to bottom right
     */
    public boolean diagonalCheck(char[][] playField, char player) {
        int playerCounter = 0;
        for (int i = 1; i < 4; i++) {
            if (playField[i][i] == player) {
                playerCounter += 1;
            }
        }
        return playerWon(playerCounter);
    }

    /**
     * Method checks three of the same X or O from bottom left to upper right
     */
    public boolean reversedDiagonalCheck(char[][] playField, char player) {
        int playerCounter = 0;
        for (int i = 3, j = 1; i > 0; i--, j++) {
            if (playField[j][i] == player) {
                playerCounter += 1;
            }
        }
        return playerWon(playerCounter);
    }
}
