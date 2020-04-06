package com.game.tictactoe.controller.test;

import com.game.tictactoe.controller.TicTacToeController;
import com.game.tictactoe.exceptions.InputInUseException;
import com.game.tictactoe.exceptions.NumberNotInRangeException;
import com.game.tictactoe.model.GameStatus;
import com.game.tictactoe.service.TicTacToeService;
import com.game.tictactoe.service.TicTacToeServiceImpl;
import com.game.tictactoe.util.TicTacToeConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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

    @Mock
    TicTacToeService ticTacToeService;
    GameStatus gameStatus;

    @BeforeEach
    void setUp() {
        this.gameStatus = new GameStatus();

        TicTacToeServiceImpl ticTacToeServiceImpl = new TicTacToeServiceImpl();
        ticTacToeServiceImpl.setGameStatus(gameStatus);

        ticTacToeService = mock(TicTacToeService.class);

        this.ticTacToeController = new TicTacToeController();

        ticTacToeController.setGameStatus(gameStatus);
        ticTacToeController.setTicTacToeService(ticTacToeService);

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
     * Test if view name equals 'tictactoe'
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
     * Test playGame method http status return equals 200
     */
    @Test
    void testPlayGameHttpStatus() throws Exception {
        mockMvc.perform(get(TicTacToeConstants.URI_PLAY_GAME_TEMPLATE)).andExpect(status().isOk());
    }

    /**
     * Test if view name equals 'tictactoe'
     */
    @Test
    void testPlayGameViewName() throws Exception {
        mockMvc.perform(get(TicTacToeConstants.URI_PLAY_GAME_TEMPLATE))
                .andExpect(view().name(TicTacToeConstants.EXPECTED_VIEW_NAME));
    }

    /**
     * Test attribute method on return key value and object
     */
    @Test
    void testPlayGameValidInput() throws Exception {
        gameStatus.setPlayField(TicTacToeConstants.EXPECTED_X);
        mockMvc.perform(get("/playingGame?row=1&column=1"))
                .andExpect(MockMvcResultMatchers.model().attribute("playField", gameStatus.getPlayField()));
    }

    /**
     * Test winner key value and returned message
     */
    @Test
    void testPlayGameEndGame() throws Exception {
        gameStatus.setGameFinished(true);
        gameStatus.setMessage(TicTacToeConstants.PLAYER_ONE_WON_MESSAGE);
        when(ticTacToeService.winner(1, 3)).thenReturn(gameStatus);

        mockMvc.perform(get("/playingGame?row=1&column=3"))
                .andExpect(MockMvcResultMatchers.model()
                        .attribute("endgameMessage", TicTacToeConstants.PLAYER_ONE_WON_MESSAGE));

    }

    /**
     * Test number format exception message in playGame method
     */
    @Test
    void testPlayGameNumberFormatException() throws Exception {
        mockMvc.perform(get("/playingGame?row=1&column=b")).andExpect(MockMvcResultMatchers.model()
                .attribute("exceptionMessage", "b" + TicTacToeConstants.NUMBER_FORMAT_EXCEPTION_MESSAGE));
    }

    /**
     * Test NumberOutOfBounds exception in playGame method
     */
    @Test
    void testPlayGameNumberNotInRangeException() throws Exception {
        mockMvc.perform(get("/playingGame?row=4&column=0")).andExpect(MockMvcResultMatchers.model()
                .attribute("exceptionMessage", TicTacToeConstants.NUMBER_NOT_IN_RANGE_EXCEPTION_MESSAGE));
    }

    /**
     * Test AlreadyInUse exception in playGame method
     */
    @Test
    void testPlayGameInputInUseException() throws Exception {
        gameStatus.setPlayField(TicTacToeConstants.EXPECTED_X);
        mockMvc.perform(get("/playingGame?row=1&column=1")).andExpect(MockMvcResultMatchers.model()
                .attribute("exceptionMessage", TicTacToeConstants.INPUT_IN_USE_EXCEPTION_MESSAGE));

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