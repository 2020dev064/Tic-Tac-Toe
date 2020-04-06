package com.game.tictactoe.controller;

import com.game.tictactoe.util.TicTacToeConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The class will be controlling the data between the service and the view
 *
 * @Author 2020-DEV-064
 */
@Controller
public class TicTacToeController {

    /**
     * This method will print the game layout of the start page
     * The key value playfield and TicTacToe constant is used in the index.html by thymeleaf
     */
    @RequestMapping(value = "/start")
    public String printGameLayout(Model model){
        model.addAttribute("playField", TicTacToeConstants.START_GAME_PLAY_FIELD);
        return "tictactoe";
    }
}
