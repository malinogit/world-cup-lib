package org.worldcup.support.exceptions;

public class AlreadyAddedException extends Exception {

    public AlreadyAddedException() {
        super("Game between these teams is already running");
    }
}
