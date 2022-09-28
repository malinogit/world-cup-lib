package org.worldcup.support;

import org.worldcup.support.exceptions.NoParamsExceptions;
import org.worldcup.support.exceptions.WrongParamsException;

/**
 * Class that validates params for methods in class WorldCupUtils
 */
class WorldCupValidator {
    void validateStartGame(WorldCup worldCup, String homeTeam, String awayTeam) throws Exception {
        if (worldCup == null) {
            throw new NoParamsExceptions("Parameter worldCup is null");
        }
        if (homeTeam == null) {
            throw new NoParamsExceptions("Parameter homeTeam is null");
        }
        if (awayTeam == null) {
            throw new NoParamsExceptions("Parameter awayTeam is null");
        }
        if (homeTeam.equals("")) {
            throw new NoParamsExceptions("Parameter homeTeam is empty");
        }
        if (awayTeam.equals("")) {
            throw new NoParamsExceptions("Parameter awayTeam is empty");
        }
        if (homeTeam.equals(awayTeam)) {
            throw new WrongParamsException("Home team and away team has same name: " + homeTeam);
        }
        if (worldCup.getCurrentlyPlayingTeams().stream()
                .anyMatch(game ->
                        (game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam)) ||
                        (game.getHomeTeam().equals(awayTeam) && game.getAwayTeam().equals(homeTeam))
                )) {
            throw new WrongParamsException("Game between" + homeTeam + " and " + awayTeam + " already running");
        }
    }
}
