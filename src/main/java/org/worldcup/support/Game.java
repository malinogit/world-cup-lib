package org.worldcup.support;

import java.time.OffsetDateTime;

class Game implements Comparable<Game> {
    public Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    private String homeTeam;
    private String awayTeam;
    private Integer homeTeamScore = 0;
    private Integer awayTeamScore = 0;
    private final OffsetDateTime offsetDateTime = OffsetDateTime.now();
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

    @Override
    public int compareTo(Game o) {
        return o.gameOrderByScoreNumber - this.gameOrderByScoreNumber;
    }
}
