package com.lab5;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException, InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {

        Catalog catalog = new Catalog("My Books", "");
        var song = new Song("bestSong","test ","C:\\Facultate\\ProgramareAvansata\\Lab5\\Exemple");
        var book = new Book("bestBook", "Document.rtft","C:/Users/JohnSmith/OneDrive/Documents/");
        catalog.add(song);
        catalog.add(book);
        CatalogUtil.save(catalog);
        CatalogUtil.play("C:/Users/JohnSmith/OneDrive/Documents/Document.rtf");
    }

    private void testLoadView() throws InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("Exemple");
        CatalogUtil.view(catalog.findById("bestBook"));
    }
}
