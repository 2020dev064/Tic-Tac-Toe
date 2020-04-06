package com.game.tictactoe.model;

import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 *
 * This class stores the variables needed in the controller
 *
 * @Author 2020-DEV-064
 */
@Setter
@Component
public class GameStatus {
    private char[][] playField;
}
