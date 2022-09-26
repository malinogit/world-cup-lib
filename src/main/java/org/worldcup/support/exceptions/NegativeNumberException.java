package org.worldcup.support.exceptions;

public class NegativeNumberException extends Exception {


    public NegativeNumberException() {
        super("Can't set negative number as team score");
    }
}
