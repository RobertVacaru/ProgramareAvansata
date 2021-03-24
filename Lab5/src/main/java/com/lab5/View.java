package com.lab5;

import com.lab5.commands.Command;
import com.lab5.exceptions.InvalidCommand;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class View extends Command implements Serializable {
    public View(String type, String argument) throws InvalidCommand {
        super(type, argument);
    }
    public static void executeView(Item item)
    {
        try {

            //… browse or open, depending of the location type
            File file = new File(item.getLocation()+item.getName());
            if (!Desktop.isDesktopSupported()) {
                System.out.println("Desktop is not supported :(");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                desktop.open(file);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

