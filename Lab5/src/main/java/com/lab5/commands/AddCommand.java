package com.lab5.commands;

import com.lab5.Book;
import com.lab5.Catalog;
import com.lab5.Song;
import com.lab5.commands.Command;
import com.lab5.exceptions.InvalidCommand;

import java.io.Serializable;

public class AddCommand extends Command implements Serializable {
    public AddCommand(String type, String argument,String location) throws InvalidCommand {
        super(type,argument,location);
    }
    public void executeAdd(Catalog catalog)
    {
        if(type.equals("song"))
        {
            var song = new Song(argument,"test ",location);
            catalog.add(song);
        }
        else if(type.equals("book"))
        {
            var book = new Book(argument, "Document.rtft",location);
            catalog.add(book);
        }

    }

}
