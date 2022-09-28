package org.worldcup.support;

import java.time.OffsetDateTime;

class Game implements Comparable<Game> {

    private String homeTeam;
    private String AwayTeam;
    private Integer homeTeamScore = 0;
    private Integer awayTeamScore = 0;
    private final OffsetDateTime offsetDateTime = OffsetDateTime.now();
    private Integer gameOrderByScoreNumber;


    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return AwayTeam;
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
        return gameOrderByScoreNumber + ". " + homeTeam  + " " + homeTeamScore + " - " + AwayTeam + " " + awayTeamScore;
    }

    void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    void setAwayTeam(String awayTeam) {
        AwayTeam = awayTeam;
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
