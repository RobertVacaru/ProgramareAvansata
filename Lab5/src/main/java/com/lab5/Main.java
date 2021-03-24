package com.lab5;

import com.lab5.commands.*;
import com.lab5.exceptions.InvalidCatalogException;
import com.lab5.exceptions.InvalidCommand;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException, InvalidCatalogException, InvalidCommand, URISyntaxException, TemplateException {
        Main app = new Main();
        //app.testCreateSave();
        //app.testLoadView();
        app.testShell();
    }
    private void testCreateSave() throws IOException {

        Catalog catalog = new Catalog("My_Books", "C:\\Users\\JohnSmith\\OneDrive\\Desktop\\maimute\\");
        var song = new Song("bestSong","test ","C:\\Facultate\\ProgramareAvansata\\Lab5\\Exemple");
        var book = new Book("bestBook", "Document.rtft","C:/Users/JohnSmith/OneDrive/Documents/");
        catalog.add(song);
        catalog.add(book);
        CatalogUtil.save(catalog);
        CatalogUtil.play("C:/Users/JohnSmith/OneDrive/Documents/Document.rtf");
    }

    private void testLoadView() throws InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("C:\\Users\\JohnSmith\\OneDrive\\Desktop\\maimute\\My_Books");
        CatalogUtil.view(catalog.findById("bestBook"));
    }
    private void testShell() throws InvalidCatalogException, IOException, InvalidCommand, URISyntaxException, TemplateException {
        Catalog catalog = new Catalog("My_Books", "C:\\Facultate\\ProgramareAvansata\\Lab5\\Exemplu");
        String argument;
        Scanner console = new Scanner(System.in);
        while(true)
        {
        System.out.println("Enter command:");
        argument= console.next();

            if ("add".equals(argument)){
                String[] params=console.nextLine().trim().split("\\s+");
                if(params.length!=3)
                    throw new InvalidCommand();
                AddCommand add = new AddCommand(params[0], params[1],params[2]);
                add.executeAdd(catalog);
            } else if ("play".equals(argument)) {
                String[] params=console.nextLine().trim().split("\\s+");
                if(params.length!=1)
                    throw new InvalidCommand();
                PlayCommand play = new PlayCommand(params[0]);
                play.executePlay(params[0]);
            } else if ("load".equals(argument)) {
                String[] params=console.nextLine().trim().split("\\s+");
                if(params.length!=1)
                    throw new InvalidCommand();
                LoadCommand load = new LoadCommand(params[0]);
                load.executeLoad(catalog, params[0]);
            } else if ("list".equals(argument)) {
                ListCommand list = new ListCommand();
                System.out.println("\nElements of the catalog:");
                list.executeList(catalog);
            } else if ("save".equals(argument)) {
                SaveCommand save = new SaveCommand();
                save.executeSave(catalog);
            } else if("exit".equals(argument)){
                return;
            }else if("raport".equals(argument))
            {
               ReportCommand report=new ReportCommand(catalog);
                PlayCommand play = new PlayCommand("C:\\Facultate\\ProgramareAvansata\\Lab5\\Exemplu\\Raport.html");
                play.executePlay("C:\\Facultate\\ProgramareAvansata\\Lab5\\Exemplu\\Raport.html");
            } else throw new InvalidCommand();
        }
    }
}
