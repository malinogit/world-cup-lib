package org.worldcup.support;

import java.util.LinkedList;
import java.util.List;

public class WorldCup {

    public WorldCup() {
        this.currentlyPlayingTeams = new LinkedList<>();
        this.completedGames = new LinkedList<>();
    }

    private List<Game> currentlyPlayingTeams;
    private List<Game> completedGames;

    List<Game> getCurrentlyPlayingTeams() {
        return currentlyPlayingTeams;
    }

    List<Game> getCompletedGames() {
        return completedGames;
    }
}
