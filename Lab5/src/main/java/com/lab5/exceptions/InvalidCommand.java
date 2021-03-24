package com.lab5.exceptions;

public class InvalidCommand extends Exception {
    public InvalidCommand() {
        super("Not enough arguments in your command or the command name was incorrect.");
    }
}
