package org.worldcup.support;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.worldcup.support.exceptions.WrongParamsException;
import org.worldcup.support.exceptions.NoParamsExceptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * tests for method updateGame()
 */
public class WorldCupUtilsUpdateGameTest {

    private WorldCup worldCup;

    @BeforeEach
    public void init() {
        this.worldCup = new WorldCup();
    }

    @Test
    @DisplayName("Correctly updating two home teams")
    public void testUpdateGameCorrect1() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";
        Integer teamScore1 = 2;

        String homeTeam2 = "Lithuania";
        String awayTeam2 = "Latvia";
        Integer teamScore2 = 1;

        //when
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        WorldCupUtils.updateScore(worldCup, homeTeam1, teamScore1);
        WorldCupUtils.startGame(worldCup, homeTeam2, awayTeam2);
        WorldCupUtils.updateScore(worldCup, homeTeam2, teamScore2);

        //then
        Game game1 = worldCup.getCurrentPlayingTeams().stream().filter(x -> x.getHomeTeam().equals(homeTeam1)).findFirst().orElse(null);
        assertNotNull(game1);
        assertEquals(teamScore1, game1.getHomeTeamScore());

        Game game2 = worldCup.getCurrentPlayingTeams().stream().filter(x -> x.getHomeTeam().equals(homeTeam2)).findFirst().orElse(null);
        assertNotNull(game2);
        assertEquals(teamScore2, game2.getHomeTeamScore());
    }
    @Test
    @DisplayName("Correctly updating two away teams")
    public void testUpdateGameCorrect2() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";
        Integer teamScore1 = 3;

        String homeTeam2 = "Lithuania";
        String awayTeam2 = "Latvia";
        Integer teamScore2 = 3;

        //when
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        WorldCupUtils.updateScore(worldCup, awayTeam1, teamScore1);
        WorldCupUtils.startGame(worldCup, homeTeam2, awayTeam2);
        WorldCupUtils.updateScore(worldCup, awayTeam2, teamScore2);

        //then
        Game game1 = worldCup.getCurrentPlayingTeams().stream().filter(x -> x.getHomeTeam().equals(awayTeam1)).findFirst().orElse(null);
        assertNotNull(game1);
        assertEquals(teamScore1, game1.getAwayTeamScore());

        Game game2 = worldCup.getCurrentPlayingTeams().stream().filter(x -> x.getHomeTeam().equals(awayTeam2)).findFirst().orElse(null);
        assertNotNull(game2);
        assertEquals(teamScore2, game2.getAwayTeamScore());
    }

    @Test
    @DisplayName("Parameter worldCup is null for update game")
    public void testUpdateGameError1() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";
        Integer teamScore1 = 2;
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        assertThrows(NoParamsExceptions.class, () -> WorldCupUtils.updateScore(null, homeTeam1, teamScore1));
    }

    @Test
    @DisplayName("Parameter teamName is null for update game")
    public void testUpdateGameError2() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";
        Integer teamScore1 = 2;
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        assertThrows(NoParamsExceptions.class, () -> WorldCupUtils.updateScore(worldCup, null, teamScore1));
    }

    @Test
    @DisplayName("Parameter teamScore is null for update game")
    public void testUpdateGameError3() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";
        Integer teamScore1 = 2;
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        assertThrows(NoParamsExceptions.class, () -> WorldCupUtils.updateScore(worldCup, homeTeam1, null));
    }

    @Test
    @DisplayName("Selecting wrong team")
    public void testUpdateGameError4() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";
        Integer teamScore1 = 2;
        String homeTeam2 = "Lithuania";
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        assertThrows(WrongParamsException.class, () -> WorldCupUtils.updateScore(worldCup, homeTeam2, teamScore1));
    }

    @Test
    @DisplayName("Trying to set negative number")
    public void testUpdateGameError5() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";
        Integer teamScore1 = -2;
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        assertThrows(WrongParamsException.class, () -> WorldCupUtils.updateScore(worldCup, homeTeam1, teamScore1));
    }


}
