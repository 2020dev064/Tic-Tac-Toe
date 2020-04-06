package com.game.tictactoe.model;

import com.game.tictactoe.util.TicTacToeConstants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * This class stores the variables needed in the controller
 *
 * @Author 2020-DEV-064
 */
@Setter
@Getter
@Component
public class GameStatus {
    private char[][] playField = TicTacToeConstants.START_GAME_PLAY_FIELD;;
}
