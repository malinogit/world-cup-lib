package org.worldcup.support.service;

import org.worldcup.support.model.WorldCup;

public interface ScoreBoardSupp {
    void startGame(WorldCup worldCup, String team1, String team2);

    void addGoal(WorldCup worldCup, String team);

    void removeGoal(WorldCup worldCup, String team);

    void finishGame(WorldCup worldCup, String team1, String team2);

    String getScoreBoard(WorldCup worldCup);

}
