package org.worldcup.support;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class WorldCup {

    public WorldCup() {
        this.currentlyPlayingTeams = new LinkedList<>();
        this.completedGames = new LinkedList<>();
    }

    private final List<Game> currentlyPlayingTeams;

    private final List<Game> completedGames;

    List<Game> getCurrentlyPlayingTeams() {
        return currentlyPlayingTeams;
    }

    List<Game> getCompletedGames() {
        return completedGames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorldCup worldCup = (WorldCup) o;
        return Objects.equals(currentlyPlayingTeams, worldCup.currentlyPlayingTeams) && Objects.equals(completedGames, worldCup.completedGames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentlyPlayingTeams, completedGames);
    }
}
