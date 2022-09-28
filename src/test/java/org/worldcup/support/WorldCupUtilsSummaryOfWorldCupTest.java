package org.worldcup.support;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.worldcup.support.exceptions.NoParamsExceptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * tests for method summaryOfGames()
 */
public class WorldCupUtilsSummaryOfWorldCupTest {

    private WorldCup worldCup;

    @BeforeEach
    public void init() {
        this.worldCup = new WorldCup();
    }

    @Test
    @DisplayName("Correctly returns of world cup")
    public void testSummaryCorrect2() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";
        Integer teamScore11 = 1;
        Integer teamScore12 = 1;

        String homeTeam2 = "Lithuania";
        String awayTeam2 = "Latvia";
        Integer teamScore21 = 3;
        Integer teamScore22 = 5;

        String homeTeam3 = "Argentina";
        String awayTeam3 = "Armenia";
        Integer teamScore31 = 2;
        Integer teamScore32 = 1;

        String homeTeam4 = "Germany";
        String awayTeam4 = "Georgia";
        Integer teamScore41 = 2;
        Integer teamScore42 = 0;

        //when
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        WorldCupUtils.updateScore(worldCup, homeTeam1, teamScore11);
        WorldCupUtils.updateScore(worldCup, awayTeam1, teamScore12);

        WorldCupUtils.startGame(worldCup, homeTeam2, awayTeam2);
        WorldCupUtils.updateScore(worldCup, homeTeam2, teamScore21);
        WorldCupUtils.updateScore(worldCup, awayTeam2, teamScore22);

        WorldCupUtils.startGame(worldCup, homeTeam3, awayTeam3);
        WorldCupUtils.updateScore(worldCup, homeTeam3, teamScore31);
        WorldCupUtils.updateScore(worldCup, awayTeam3, teamScore32);

        WorldCupUtils.startGame(worldCup, homeTeam4, awayTeam4);
        WorldCupUtils.updateScore(worldCup, homeTeam4, teamScore41);
        WorldCupUtils.updateScore(worldCup, awayTeam4, teamScore42);

        WorldCupUtils.finishGame(worldCup, homeTeam1, awayTeam1);
        WorldCupUtils.finishGame(worldCup, homeTeam2, awayTeam2);
        WorldCupUtils.finishGame(worldCup, homeTeam3, awayTeam3);
        WorldCupUtils.finishGame(worldCup, homeTeam4, awayTeam4);

        List<Game> summary = WorldCupUtils.summaryOfWorldCup(worldCup);

        //then
        assertEquals(4, summary.size());
        Game game1 = summary.stream().filter(x -> homeTeam1.equals(x.getHomeTeam())).findFirst().orElseThrow(() -> new Exception("Error in adding teams"));
        Game game2 = summary.stream().filter(x -> homeTeam2.equals(x.getHomeTeam())).findFirst().orElseThrow(() -> new Exception("Error in adding teams"));
        Game game3 = summary.stream().filter(x -> homeTeam3.equals(x.getHomeTeam())).findFirst().orElseThrow(() -> new Exception("Error in adding teams"));
        Game game4 = summary.stream().filter(x -> homeTeam4.equals(x.getHomeTeam())).findFirst().orElseThrow(() -> new Exception("Error in adding teams"));

        assertEquals(4, game1.getGameOrderByScoreNumber());
        assertEquals(1, game2.getGameOrderByScoreNumber());
        assertEquals(2, game3.getGameOrderByScoreNumber());
        assertEquals(3, game4.getGameOrderByScoreNumber());

        assertEquals("4. Poland 1 - France 1", game1.gameSummary());
    }

    @Test
    @DisplayName("Parameter worldCup is null for summary")
    public void testSummaryError1() throws Exception {
        //given
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";
        Integer teamScore1 = 2;
        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        assertThrows(NoParamsExceptions.class, () -> WorldCupUtils.summaryOfWorldCup(worldCup));
    }

}
