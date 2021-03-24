package com.lab5.exceptions;

public class InvalidCommand extends Exception {
    public InvalidCommand() {
        super("Not enough arguments in your command.");
    }
}
