package org.worldcup.support;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.worldcup.support.exceptions.NoParamsExceptions;
import org.worldcup.support.exceptions.WrongParamsException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * tests for method startGame()
 */
public class WorldCupUtilsStartGameTest {

    private WorldCup worldCup;

    @BeforeEach
    public void init() {
        this.worldCup = new WorldCup();
    }

    @Test
    @DisplayName("Correctly starting game")
    public void testStartGameCorrect1() throws Exception {
        //given
        String homeTeam = "Poland";
        String awayTeam = "France";

        //when
        WorldCupUtils.startGame(worldCup, homeTeam, awayTeam);

        //then
        assertEquals(1, worldCup.getCurrentPlayingTeams().size());
    }

    @Test
    @DisplayName("Correctly starting two games")
    public void testStartGameCorrect2() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";

        String homeTeam2 = "Lithuania";
        String awayTeam2 = "Latvia";

        //when
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        WorldCupUtils.startGame(worldCup, homeTeam2, awayTeam2);

        //then
        assertEquals(2, worldCup.getCurrentPlayingTeams().size());
    }

    @Test
    @DisplayName("Parameter worldCup not completed for start game")
    public void testStartGameError1() {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";
        assertThrows(NoParamsExceptions.class, () -> WorldCupUtils.startGame(null, homeTeam1, awayTeam1) );
    }

    @Test
    @DisplayName("Parameter homeTeam not completed for start game")
    public void testStartGameError2() {
        //given
        String homeTeam1 = null;
        String awayTeam1 = "France";
        assertThrows(NoParamsExceptions.class, () -> WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1) );
    }

    @Test
    @DisplayName("Parameter homeTeam is empty string for start game")
    public void testStartGameError3() {
        //given
        String homeTeam1 = "";
        String awayTeam1 = "France";
        assertThrows(NoParamsExceptions.class, () -> WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1) );
    }

    @Test
    @DisplayName("Parameter awayTeam not completed for start game")
    public void testStartGameError4() {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = null;
        assertThrows(NoParamsExceptions.class, () -> WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1) );
    }

    @Test
    @DisplayName("Parameter awayTeam is empty string for start game")
    public void testStartGameError5() {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "";
        assertThrows(NoParamsExceptions.class, () -> WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1) );
    }

    @Test
    @DisplayName("Trying to add already running game")
    public void testStartGameError6() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";

        //when
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);

        assertThrows(WrongParamsException.class, () -> WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1) );
    }

    @Test
    @DisplayName("Trying to add two same teams")
    public void testStartGameError7() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "Poland";

        //when
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);

        assertThrows(WrongParamsException.class, () -> WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1) );
    }

}
