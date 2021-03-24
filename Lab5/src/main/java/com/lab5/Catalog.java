package com.lab5;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Catalog implements Serializable {

    private String name;
    private String path;
    public List<Item> items = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public void list() {
        for(var x : items) {
            System.out.println(x.getId() + " ");
        }
    }
    /*public void play(File file) throws IOException {
        Desktop.getDesktop().open(file);
    }*/

    public void add(Item item) {
            items.add(item);
        }
        public Item findById(String id) {
            for (Item item : items) {
                if (item.getId().equals(id)) {
                    return item;
                }
            }
            return null;
        }

    public String getPath() {
            return path;
    }
}


