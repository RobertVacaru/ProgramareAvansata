package com.lab5.commands;

import com.lab5.exceptions.InvalidCommand;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class PlayCommand extends Command implements Serializable {
    public PlayCommand(String location) throws InvalidCommand {
        super(location);
    }
    public  void executePlay(String location)
    {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop desktop = Desktop.getDesktop();
                File myFile;
                myFile = new File(String.valueOf(location));
                desktop.open(myFile);
            } catch (IOException ex) {}
        }
    }
}
