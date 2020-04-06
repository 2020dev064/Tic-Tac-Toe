package com.game.tictactoe.controller.test;

import com.game.tictactoe.controller.TicTacToeController;
import com.game.tictactoe.exceptions.InputInUseException;
import com.game.tictactoe.exceptions.NumberNotInRangeException;
import com.game.tictactoe.util.TicTacToeConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


/**
 * Class for testing all the controller methods
 *
 * @Author 2020-DEV-064
 */
class TicTacToeControllerTest {

    MockMvc mockMvc;
    TicTacToeController ticTacToeController;


    @BeforeEach
    void setUp() {
        this.ticTacToeController = new TicTacToeController();

        mockMvc = MockMvcBuilders.standaloneSetup(ticTacToeController).build();
    }

    /**
     * Test http status return equals 200
     */
    @Test
    void testPrintGameLayoutHttp() throws Exception {
        mockMvc.perform(get(TicTacToeConstants.URI_START_TEMPLATE)).andExpect(status().isOk());
    }

    /**
     * Test if view name equals 'tictactoe/index'
     */
    @Test
    void testPrintGameLayoutViewName() throws Exception {
        mockMvc.perform(get(TicTacToeConstants.URI_START_TEMPLATE))
                .andExpect(view().name(TicTacToeConstants.EXPECTED_VIEW_NAME));
    }

    /**
     * Test attribute method on return of the key value and object
     */
    @Test
    void testGameLayoutAvailable() throws Exception {
        mockMvc.perform(get(TicTacToeConstants.URI_START_TEMPLATE)).andExpect(
                MockMvcResultMatchers.model().attribute("playField", TicTacToeConstants.START_GAME_PLAY_FIELD));
    }

    /**
     * Test numberNotInRange method that it throws the right exception with
     * different values And that it doesn't throw an exception when the number is within the play field length
     */
    @Test
    void testNumberNotInRange() {
        assertThrows(NumberNotInRangeException.class, () -> ticTacToeController.numberNotInRange(0));
        assertThrows(NumberNotInRangeException.class, () -> ticTacToeController.numberNotInRange(4));
        assertThrows(NumberNotInRangeException.class, () -> ticTacToeController.numberNotInRange(-1));

        assertDoesNotThrow(() -> ticTacToeController.numberNotInRange(1));
    }

    /**
     * Test inPutInUse method that it throws the right exception when the field is
     * already occupied by X or O And that it doesn't throw an exception when the field is free to use
     */
    @Test
    void testInputInUse() {
        assertThrows(InputInUseException.class,
                () -> ticTacToeController.inputInUSe(1, 1, TicTacToeConstants.EXPECTED_X));

        assertThrows(InputInUseException.class,
                () -> ticTacToeController.inputInUSe(1, 1, TicTacToeConstants.EXPECTED_O));

        assertDoesNotThrow(() -> ticTacToeController.inputInUSe(1, 2, TicTacToeConstants.EXPECTED_X));
    }

    /**
     * Test numberFormat method that it throws NumberFormatException when given
     * String is not a Integer value And the method doesn't throw an exception when given String is a Integer value
     */
    @Test
    void testNumberFormat() {
        assertThrows(NumberFormatException.class, () -> ticTacToeController.numberFormat("a"));
        assertThrows(NumberFormatException.class, () -> ticTacToeController.numberFormat("2.0"));

        assertDoesNotThrow(() -> ticTacToeController.numberFormat("1"));
    }
}