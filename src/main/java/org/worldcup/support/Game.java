package org.worldcup.support;

import java.time.OffsetDateTime;
import java.util.Objects;

class Game implements Comparable<Game> {
    public Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.offsetDateTime = OffsetDateTime.now();
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
    }

    private String homeTeam;
    private String awayTeam;
    private Integer homeTeamScore;
    private Integer awayTeamScore;
    private final OffsetDateTime offsetDateTime;
    private Integer gameOrderByScoreNumber;


    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }
    public Integer getGameOrderByScoreNumber() {
        return gameOrderByScoreNumber;
    }

    public String gameSummary() {
        return gameOrderByScoreNumber + ". " + homeTeam  + " " + homeTeamScore + " - " + awayTeam + " " + awayTeamScore;
    }

    @Override
    public int compareTo(Game o) {
        return o.gameOrderByScoreNumber - this.gameOrderByScoreNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(homeTeam, game.homeTeam) && Objects.equals(awayTeam, game.awayTeam) && Objects.equals(homeTeamScore, game.homeTeamScore) && Objects.equals(awayTeamScore, game.awayTeamScore) && Objects.equals(offsetDateTime, game.offsetDateTime) && Objects.equals(gameOrderByScoreNumber, game.gameOrderByScoreNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, homeTeamScore, awayTeamScore, offsetDateTime, gameOrderByScoreNumber);
    }

    void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    void setAwayTeamScore(Integer awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    OffsetDateTime getOffsetDateTime() {
        return offsetDateTime;
    }

    void setGameOrderByScoreNumber(Integer gameOrderByScoreNumber) {
        this.gameOrderByScoreNumber = gameOrderByScoreNumber;
    }
}
