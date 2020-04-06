package com.game.tictactoe.util;

/**
 * All the constant variables will be stored in this class
 *
 * @Author 2020-DEV-064
 */
public class TicTacToeConstants {

    public static final String URI_START_TEMPLATE = "/start";

    public static final String URI_PLAY_GAME_TEMPLATE = "/playingGame";

    public static final String EXPECTED_VIEW_NAME = "tictactoe";

    public static final char PLAYER_ONE_X = 'X';

    public static final char PLAYER_TWO_O = 'O';

    public static final String NUMBER_NOT_IN_RANGE_EXCEPTION_MESSAGE = "Number must be between 1 and 3.";

    public static final String INPUT_IN_USE_EXCEPTION_MESSAGE = "This position is already in use.";

    public static final String NUMBER_FORMAT_EXCEPTION_MESSAGE =
            " is not a valid number, characters and decimal numbers aren't allowed.";

    public static final String PLAYER_ONE_WON_MESSAGE = "Player one won!!!";

    public static final String PLAYER_TWO_WON_MESSAGE = "Player two won!!!";

    public static final String DRAW_MESSAGE = "It's a draw...";

    public static final String ENDGAME_MESSAGE = "Ready for playing tic tac toe";

    public static final String HTML_TEMPLATE = "tictactoe";

    public static final String EXCEPTION_MESSAGE = "exceptionMessage";

    public static final String ENDGAME_MESSAGE_KEY_VALUE = "endgameMessage";

    public static final String PLAY_FIELD_KEY_VALUE = "playField";

    public static final String ENDGAME_HTML_RETURN = "endgame";

    public static final char[][] START_GAME_PLAY_FIELD = {{' ', '1', '2', '3'},
            {'1', '-', '-', '-'},
            {'2', '-', '-', '-'},
            {'3', '-', '-', '-'}};

    public static final char[][] EXPECTED_X = {{' ', '1', '2', '3'},
            {'1', 'X', '-', '-'},
            {'2', '-', '-', '-'},
            {'3', '-', '-', '-'}};

    public static final char[][] EXPECTED_O = {{' ', '1', '2', '3'},
            {'1', 'O', '-', '-'},
            {'2', '-', '-', '-'},
            {'3', '-', '-', '-'}};

    public static final char[][] PLAYER_ONE_HORIZONTAL_WIN = {{' ', '1', '2', '3'},
            {'1', 'X', 'X', 'X'},
            {'2', '-', '-', '-'},
            {'3', '-', '-', '-'}};

    public static final char[][] PLAYER_TWO_VERTICAL_WIN = {{' ', '1', '2', '3'},
            {'1', 'O', '-', '-'},
            {'2', 'O', '-', '-'},
            {'3', 'O', '-', '-'}};

    public static final char[][] PLAYER_ONE_DIAGONAL_WIN = {{' ', '1', '2', '3'},
            {'1', 'X', '-', '-'},
            {'2', '-', 'X', '-'},
            {'3', '-', '-', 'X'}};

    public static final char[][] PLAYER_TWO_REVERSED_DIAGONAL_WIN = {{' ', '1', '2', '3'},
            {'1', '-', '-', 'O'},
            {'2', '-', 'O', '-'},
            {'3', 'O', '-', '-'}};
}
