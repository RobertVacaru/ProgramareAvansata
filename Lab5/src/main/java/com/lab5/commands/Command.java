package com.lab5.commands;

import com.lab5.exceptions.InvalidCommand;

public abstract class Command {
    public String type;
    public String argument;
    public String location;

    public Command() {
    }

    public Command(String type, String argument, String location) {
        this.type = type;
        this.argument = argument;
        this.location = location;
    }

    public Command(String type, String argument) throws InvalidCommand {
           this.type = type;
        if(argument.equals("")) {
            throw new InvalidCommand();
        }
        else   this.argument = argument;

    }


    public Command(String argument) throws InvalidCommand {
        if(argument.equals(""))
            throw new InvalidCommand();
        else this.argument = argument;
    }
}
