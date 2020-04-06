package com.game.tictactoe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicTacToeController {

    @RequestMapping(value = "/start")
    public String printGameLayout(){
        return "tictactoe";
    }
}
