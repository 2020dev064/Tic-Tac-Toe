package com.game.tictactoe.service.test;

import com.game.tictactoe.model.GameStatus;
import com.game.tictactoe.service.TicTacToeServiceImpl;
import com.game.tictactoe.util.TicTacToeConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Here you can find all tests for the TicTacToeImpl class
 *
 * @Author 2020-DEV-064
 */
class TicTacToeServiceImplTest {

    GameStatus gameStatus;
    TicTacToeServiceImpl ticTacToeServiceImpl;

    @BeforeEach
    void setUp() {
        this.gameStatus = new GameStatus();
        this.ticTacToeServiceImpl = new TicTacToeServiceImpl();
        ticTacToeServiceImpl.setGameStatus(gameStatus);
    }

    /**
     * Test the character that is drawn when playerTurn method is called
     *By calling the method twice the playerCounter will change as well so it's possible to test both X and O
     */
    @Test
    void testPlayerTurn() {

        ticTacToeServiceImpl.playerTurn(1, 1);
        assertEquals('X', ticTacToeServiceImpl.getPlayField()[1][1]);

        ticTacToeServiceImpl.playerTurn(1, 1);
        assertEquals('O', ticTacToeServiceImpl.getPlayField()[1][1]);
    }

    /**
     * Test playerWon method if player counter equals three then return true else false
     */
    @Test
    void testPlayerWon() {
        assertTrue(ticTacToeServiceImpl.playerWon(3));
        assertFalse(ticTacToeServiceImpl.playerWon(-1));
    }

    /**
     * Test horizontalCheck method for three X's in a row
     */
    @Test
    void testHorizontalCheck() {
        assertTrue(ticTacToeServiceImpl
                .horizontalCheck(TicTacToeConstants.PLAYER_ONE_HORIZONTAL_WIN, TicTacToeConstants.PLAYER_ONE_X,
                        1));
        assertFalse(ticTacToeServiceImpl
                .horizontalCheck(TicTacToeConstants.EXPECTED_X, TicTacToeConstants.PLAYER_ONE_X,
                        1));
    }

    /**
     * Test verticalCheck for three O's in a column
     */
    @Test
    void testVerticalCheck() {
        assertTrue(ticTacToeServiceImpl.verticalCheck(TicTacToeConstants.PLAYER_TWO_VERTICAL_WIN,
                TicTacToeConstants.PLAYER_TWO_O, 1));
        assertFalse(ticTacToeServiceImpl.verticalCheck(TicTacToeConstants.EXPECTED_O, TicTacToeConstants.PLAYER_TWO_O,
                1));
    }

    /**
     * Test diagonalCheck for three X's diagonal from upper left to bottom right
     */
    @Test
    void testPlayerOneDiagonalCheck() {
        assertTrue(ticTacToeServiceImpl
                .diagonalCheck(TicTacToeConstants.PLAYER_ONE_DIAGONAL_WIN, TicTacToeConstants.PLAYER_ONE_X));
        assertFalse(ticTacToeServiceImpl
                .diagonalCheck(TicTacToeConstants.EXPECTED_X, TicTacToeConstants.PLAYER_ONE_X));
    }

    /**
     * Test reversedDiagonalCheck for three O's reversed diagonal from bottom left to upper right
     */
    @Test
    void testReversedPlayerTwoDiagonalCheck() {
        assertTrue(ticTacToeServiceImpl
                .reversedDiagonalCheck(TicTacToeConstants.PLAYER_TWO_REVERSED_DIAGONAL_WIN,
                        TicTacToeConstants.PLAYER_TWO_O));
        assertFalse(ticTacToeServiceImpl
                .reversedDiagonalCheck(TicTacToeConstants.EXPECTED_O, TicTacToeConstants.PLAYER_TWO_O));
    }
}