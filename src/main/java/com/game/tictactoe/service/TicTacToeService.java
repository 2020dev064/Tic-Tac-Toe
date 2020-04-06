package com.game.tictactoe.service;

import com.game.tictactoe.model.GameStatus;

/**
 * @Author 2020-DEV-064
 */
public interface TicTacToeService {

    GameStatus winner(int row, int column);
}
