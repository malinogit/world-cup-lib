package org.worldcup.support.exceptions;

public class WrongTeamException extends Exception {


    public WrongTeamException() {
        super("This team isn't in the game");
    }
}
