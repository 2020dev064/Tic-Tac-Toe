package com.game.tictactoe.exceptions;

/**
 * @Author 2020-DEV-064
 */
public class InputInUseException extends Exception {

    private static final long serialVersionUID = 1L;

    public InputInUseException(String message) {
        super(message);
    }
}
