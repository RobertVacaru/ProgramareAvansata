package com.lab5.commands;

import com.lab5.Catalog;

import java.io.*;

public class SaveCommand extends Command implements Serializable {

    public SaveCommand() {
    }
    public void executeSave(Catalog catalog)throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(new File(catalog.getPath() + catalog.getName())))) {
            oos.writeObject(catalog);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
