package org.worldcup.support;

import java.util.LinkedList;
import java.util.List;

public class WorldCup {

    public WorldCup() {
        this.participatingTeams = new LinkedList<>();
        this.currentPlayingTeams = new LinkedList<>();
        this.completedGames = new LinkedList<>();
    }

    private List<Team> participatingTeams;
    private List<Game> currentPlayingTeams;
    private List<Game> completedGames;

    List<Team> getParticipatingTeams() {
        return participatingTeams;
    }

    void setParticipatingTeams(List<Team> participatingTeams) {
        this.participatingTeams = participatingTeams;
    }

    List<Game> getCurrentPlayingTeams() {
        return currentPlayingTeams;
    }

    void setCurrentPlayingTeams(List<Game> currentPlayingTeams) {
        this.currentPlayingTeams = currentPlayingTeams;
    }

    List<Game> getCompletedGames() {
        return completedGames;
    }

    void setCompletedGames(List<Game> completedGames) {
        this.completedGames = completedGames;
    }
}
