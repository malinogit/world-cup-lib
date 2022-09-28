package org.worldcup.support;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.worldcup.support.exceptions.NoParamsExceptions;
import org.worldcup.support.exceptions.WrongParamsException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * tests for method finishGame()
 */
public class WorldCupUtilsFinishGameTest {

    private WorldCup worldCup;

    @BeforeEach
    public void init() {
        this.worldCup = new WorldCup();
    }

    @Test
    @DisplayName("Correctly finishing two games")
    public void testFinishGameCorrect1() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";

        String homeTeam2 = "Lithuania";
        String awayTeam2 = "Latvia";

        //when
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        WorldCupUtils.startGame(worldCup, homeTeam2, awayTeam2);

        assertEquals(2, worldCup.getCurrentlyPlayingTeams().size());
        assertEquals(0, worldCup.getCompletedGames().size());

        WorldCupUtils.finishGame(worldCup, homeTeam1, awayTeam1);
        WorldCupUtils.finishGame(worldCup, homeTeam2, awayTeam2);

        assertEquals(0, worldCup.getCurrentlyPlayingTeams().size());
        assertEquals(2, worldCup.getCompletedGames().size());
    }

    @Test
    @DisplayName("Parameter worldCup is null for finish game")
    public void testFinishGameError1() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";
        Integer teamScore1 = 2;
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        assertThrows(NoParamsExceptions.class, () -> WorldCupUtils.updateScore(null, homeTeam1, teamScore1));
    }

    @Test
    @DisplayName("Parameter homeTeam is null for finish game")
    public void testFinishGameError2() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        assertThrows(NoParamsExceptions.class, () -> WorldCupUtils.finishGame(worldCup, null, awayTeam1));
    }

    @Test
    @DisplayName("Parameter awayTeam is null for finish game")
    public void testFinishGameError3() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        assertThrows(NoParamsExceptions.class, () -> WorldCupUtils.finishGame(worldCup, homeTeam1, null));
    }

    @Test
    @DisplayName("Selecting wrong team")
    public void testFinishGameError4() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";
        String homeTeam2 = "Lithuania";
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        assertThrows(WrongParamsException.class, () -> WorldCupUtils.finishGame(worldCup, homeTeam1, homeTeam2));
    }

}
