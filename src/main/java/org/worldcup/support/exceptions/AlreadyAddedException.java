package org.worldcup.support.exceptions;

public class AlreadyAddedException extends Exception {

    public AlreadyAddedException() {
        super("Team can't run two games on the same time");
    }
}
