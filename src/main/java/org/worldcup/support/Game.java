package org.worldcup.support;

class Game {

    private String homeTeam;
    private String AwayTeam;
    private Integer homeTeamScore = 0;
    private Integer awayTeamScore = 0;

    String getHomeTeam() {
        return homeTeam;
    }

    void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    String getAwayTeam() {
        return AwayTeam;
    }

    void setAwayTeam(String awayTeam) {
        AwayTeam = awayTeam;
    }

    Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    Integer getAwayTeamScore() {
        return awayTeamScore;
    }

    void setAwayTeamScore(Integer awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    String gameStats() {
        return homeTeam  + " " + homeTeamScore + " - " + AwayTeam + " " + awayTeamScore;
    }
}
