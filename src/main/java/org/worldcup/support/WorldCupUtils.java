package org.worldcup.support;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WorldCupUtils {


    /**
     *
     * Start game between two teams
     *
     * @param worldCup world cup object
     * @param homeTeam home team participating in game
     * @param awayTeam away team participating in game
     */
    public static void startGame(WorldCup worldCup, String homeTeam, String awayTeam) throws Exception {
    }

    /**
     *
     * Update score of team that currently playing
     *
     * @param worldCup world cup object
     * @param teamName select which team score need to be updated
     * @param teamScore set team score
     */
    public static void updateScore(WorldCup worldCup, String teamName, Integer teamScore) {

    }

    /**
     *
     * Finish running game between two teams
     *
     * @param worldCup world cup object
     * @param homeTeam home team participating in game
     * @param awayTeam away team participating in game
     */
    public static void finishGame(WorldCup worldCup, String homeTeam, String awayTeam) {

    }

    /**
     *
     * @param worldCup world cup object
     * @return summary of games by total score
     */
    public static List<Game> summaryOfGames(WorldCup worldCup) {
        return Collections.emptyList();
    }
}
