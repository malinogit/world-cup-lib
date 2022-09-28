package org.worldcup.support;

import org.worldcup.support.exceptions.GameNotFoundException;
import org.worldcup.support.exceptions.NoParamsExceptions;

import java.util.Collections;
import java.util.List;

public class WorldCupUtils {

    private static final WorldCupValidator validator = new WorldCupValidator();
    /**
     *
     * Start game between two teams
     *
     * @param worldCup world cup object
     * @param homeTeam home team participating in game
     * @param awayTeam away team participating in game
     */
    public static void startGame(WorldCup worldCup, String homeTeam, String awayTeam) throws Exception {
        validator.validateStartGame(worldCup, homeTeam, awayTeam);
        Game game = new Game(homeTeam, awayTeam);
        worldCup.getCurrentlyPlayingTeams().add(game);
    }

    /**
     *
     * Update score of team that currently playing
     *
     * @param worldCup world cup object
     * @param teamName select which team score need to be updated
     * @param teamScore set team score
     */
    public static void updateScore(WorldCup worldCup, String teamName, Integer teamScore) throws Exception {
        validator.validateUpdateGame(worldCup, teamName, teamScore);

        Game game = worldCup.getCurrentlyPlayingTeams().stream()
                .filter(g -> g.getHomeTeam().equals(teamName) || g.getAwayTeam().equals(teamName))
                .findAny()
                .orElseThrow(() -> new GameNotFoundException("Team " + teamName + " is not playing right now"));

        if (game.getHomeTeam().equals(teamName)) {
            game.setHomeTeamScore(teamScore);
        }
        if (game.getAwayTeam().equals(teamName)) {
            game.setAwayTeamScore(teamScore);
        }
    }

    /**
     *
     * Finish running game between two teams
     *
     * @param worldCup world cup object
     * @param homeTeam home team participating in game
     * @param awayTeam away team participating in game
     */
    public static void finishGame(WorldCup worldCup, String homeTeam, String awayTeam) throws Exception {

    }

    /**
     *
     * @param worldCup world cup object
     * @return summary of games by total score
     */
    public static List<Game> summaryOfGames(WorldCup worldCup) throws Exception {
        return Collections.emptyList();
    }
}
