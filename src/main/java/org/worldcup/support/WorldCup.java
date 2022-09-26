package org.worldcup.support;

import java.util.LinkedList;
import java.util.List;

public class WorldCup {

    public WorldCup() {
        this.currentPlayingTeams = new LinkedList<>();
        this.completedGames = new LinkedList<>();
    }

    private List<Game> currentPlayingTeams;
    private List<Game> completedGames;

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
