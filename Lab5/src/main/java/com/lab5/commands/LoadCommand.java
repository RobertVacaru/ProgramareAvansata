package com.lab5.commands;

import com.lab5.Catalog;
import com.lab5.exceptions.InvalidCatalogException;
import com.lab5.exceptions.InvalidCommand;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class LoadCommand extends Command implements Serializable {
    public LoadCommand(String argument) throws InvalidCommand {
        super(argument);
    }
    public  void executeLoad(Catalog catalog, String path) throws InvalidCatalogException{
        try (var oos = new ObjectInputStream(new FileInputStream(path))) {
            catalog = (Catalog) oos.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
