package com.game.tictactoe.util;

/**
 * All the constant variables will be stored in this class
 *
 * @Author 2020-DEV-064
 */
public class TicTacToeConstants {

    public static final String URI_START_TEMPLATE = "/start";

    public static final String EXPECTED_VIEW_NAME = "tictactoe";

    public static final char PLAYER_ONE_X = 'X';

    public static final char PLAYER_TWO_O = 'O';

    public static final String NUMBER_NOT_IN_RANGE_EXCEPTION_MESSAGE = "Number must be between 1 and 3.";

    public static final char[][] START_GAME_PLAY_FIELD = {{' ', '1', '2', '3'},
            {'1', '-', '-', '-'},
            {'2', '-', '-', '-'},
            {'3', '-', '-', '-'}};
}
