package com.lab5;

import java.awt.*;
import java.io.*;
import java.util.Date;

public class CatalogUtil implements Serializable {

    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    /*public static void list(Catalog catalog) {
        for(var x: catalog.items)
             System.out.println(x + " ");
    }*/

    public static Catalog load(String path)
            throws InvalidCatalogException {
        Catalog catalog = null;
        try (var oos = new ObjectInputStream(new FileInputStream(path))) {
            catalog = (Catalog) oos.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return catalog;
    }
    public static void play(String file) {
    if (Desktop.isDesktopSupported()) {
        try {
            Desktop desktop = Desktop.getDesktop();
            File myFile;
            myFile = new File(String.valueOf(file));
            desktop.open(myFile);
        } catch (IOException ex) {}
    }}
    public static void view(Item item) {
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
