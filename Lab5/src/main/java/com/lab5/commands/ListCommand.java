package com.lab5.commands;

import com.lab5.Catalog;

import java.io.Serializable;

public class ListCommand extends Command implements Serializable {
    public ListCommand() {
    }
    public void executeList(Catalog catalog)
    {
        catalog.list();
    }
}
