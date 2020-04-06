package com.game.tictactoe.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Here you can find all tests for the TicTacToeImpl class
 *
 * @Author 2020-DEV-064
 */
class TicTacToeServiceImplTest {

    TicTacToeServiceImpl ticTacToeServiceImpl;

    @BeforeEach
    void setUp() {
        this.ticTacToeServiceImpl = new TicTacToeServiceImpl();
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
}