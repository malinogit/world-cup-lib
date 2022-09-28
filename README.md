# word-cup-lib
##  Collection of methods to manage Football World Cup Score Board
### Library gives you set of methods to manage game score. <br/> The features that it's provides:
* Classes:
* * WorldCup - holding information about running and completed games
* * Game - single game with game summary
* * WorldCupUtils - service with methods that library provides
* Methods:
* * startGame() - adding new game between two teams
* * updateScore() - update running game between two teams
* * finishGame() - completed game between two teams
* * summaryOfWorldCup() - returns summary of completed games by total score



## Example of usage:

```java
public class Main {
    public static void main(String[] args) throws Exception {
        WorldCup worldCup = new WorldCup();
        String homeTeam1 = "Poland";
        String awayTeam1 = "France";
        Integer teamScore11 = 2;
        Integer teamScore12 = 1;

        WorldCupUtils.startGame(worldCup, homeTeam1, awayTeam1);
        WorldCupUtils.updateScore(worldCup, homeTeam1, teamScore11);
        WorldCupUtils.updateScore(worldCup, awayTeam1, teamScore12);
        WorldCupUtils.finishGame(worldCup, homeTeam1, awayTeam1);

        List<Game> summary = WorldCupUtils.summaryOfWorldCup(worldCup);
        summary.forEach(g -> System.out.println(g.gameSummary()));
    }

    /*
            These line of code will produce:
            1. Poland 2 - France 1
     */
}
```