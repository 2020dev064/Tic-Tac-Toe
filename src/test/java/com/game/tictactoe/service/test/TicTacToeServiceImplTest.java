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
}