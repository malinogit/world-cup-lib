package org.worldcup.support;

import org.worldcup.support.exceptions.GameNotFoundException;
import org.worldcup.support.exceptions.NoParamsExceptions;
import org.worldcup.support.exceptions.WrongParamsException;

/**
 * Class that validates params for methods in class WorldCupUtils
 */
class WorldCupValidator {

    void validateStartGame(WorldCup worldCup, String homeTeam, String awayTeam) throws Exception {
        worldCupValidation(worldCup);
        teamValidation(worldCup, homeTeam);
        teamValidation(worldCup, awayTeam);
    }

    void validateUpdateGame(WorldCup worldCup, String teamName, Integer teamScore) throws Exception {
        worldCupValidation(worldCup);
        teamFieldValidation(teamName);
        teamScoreValidation(teamScore);
    }

    private void teamValidation(WorldCup worldCup, String team) throws Exception {
        teamFieldValidation(team);
        if (worldCup.getCurrentlyPlayingTeams().stream().anyMatch(game ->
                (game.getHomeTeam().equals(team) || game.getAwayTeam().equals(team))
        )) {
            throw new WrongParamsException("Team " + team + " already playing");
        }

    }

    private void worldCupValidation(WorldCup worldCup) throws NoParamsExceptions {
        if (worldCup == null) {
            throw new NoParamsExceptions("Parameter worldCup is null");
        }
    }

    private void teamScoreValidation(Integer teamScore) throws Exception {
        if (teamScore == null) {
            throw new NoParamsExceptions("Parameter teamScore is null");
        }
        if (teamScore < 0) {
            throw new WrongParamsException("Trying to set score as negative number");
        }
    }

    private void teamFieldValidation(String team) throws NoParamsExceptions {
        if (team == null) {
            throw new NoParamsExceptions("Team name is null");
        }
        if (team.equals("")) {
            throw new NoParamsExceptions("Team name is empty");
        }
    }
}
