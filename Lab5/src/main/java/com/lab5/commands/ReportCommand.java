package com.lab5.commands;

import com.lab5.Catalog;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.maven.shared.utils.cli.shell.Shell;

import java.io.*;
import java.net.URISyntaxException;

public class ReportCommand extends Command{
    Catalog catalog;
    private final Configuration configuration = new Configuration();
    public ReportCommand(Catalog catalog) throws URISyntaxException, IOException, TemplateException {
        this.catalog = catalog;
        configuration.setDirectoryForTemplateLoading(new File(Shell.class.getResource("/templates").toURI()));
        Template template = configuration.getTemplate("catalog.ftl");
        Writer write = new FileWriter("C:\\Facultate\\ProgramareAvansata\\Lab5\\Exemplu\\Raport.html");
        template.process(this.catalog,write);
    }
}
