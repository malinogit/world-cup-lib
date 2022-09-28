package org.worldcup.support;

import org.worldcup.support.exceptions.GameNotFoundException;
import org.worldcup.support.exceptions.InnerException;
import org.worldcup.support.exceptions.NoParamsExceptions;

import java.util.List;
import java.util.stream.Collectors;

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
        validator.validateFinishGame(worldCup, homeTeam, awayTeam);

        Game game = worldCup.getCurrentlyPlayingTeams().stream()
                .filter(g ->
                        (g.getHomeTeam().equals(homeTeam) && g.getAwayTeam().equals(awayTeam))
                        ||
                        (g.getHomeTeam().equals(awayTeam) && g.getAwayTeam().equals(homeTeam))
                )
                .findAny()
                .orElseThrow(() -> new GameNotFoundException("Game between teams: " + homeTeam + " and " + awayTeam + "isn't running"));

        worldCup.getCurrentlyPlayingTeams().remove(game);
        worldCup.getCompletedGames().add(game);
        calculatePlaceForTeams(worldCup);
    }

    /**
     *
     * @param worldCup world cup object
     * @return summary of games by total score
     */
    public static List<Game> summaryOfWorldCup(WorldCup worldCup) throws Exception {
        validator.validateSummaryOfWorldCup(worldCup);
        return worldCup.getCompletedGames().stream().sorted().collect(Collectors.toList());
    }

    private static void calculatePlaceForTeams(WorldCup worldCup) throws NoParamsExceptions {
        if (worldCup == null) {
            throw new NoParamsExceptions("No parameter worldCup");
        }
        List<Game> sortedList = worldCup.getCompletedGames().stream().sorted((g2, g1) -> {
            int x = Integer.compare(g1.getHomeTeamScore() + g1.getAwayTeamScore(), g2.getHomeTeamScore() + g2.getAwayTeamScore());
            if (x == 0) {
                return g1.getOffsetDateTime().compareTo(g2.getOffsetDateTime());
            }
            return x;
        }).collect(Collectors.toList());
        for (int i = 1; i <= sortedList.size(); i++) {
            sortedList.get(i - 1).setGameOrderByScoreNumber(i);
        }
    }
}
