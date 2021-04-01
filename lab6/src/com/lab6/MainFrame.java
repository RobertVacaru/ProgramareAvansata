package com.lab6;

import javax.swing.*;
import static java.awt.BorderLayout.*;
public class MainFrame extends JFrame {

    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new DrawingPanel(this);
        configPanel=new ConfigPanel(this);
        controlPanel=new ControlPanel(this);

        add(controlPanel,SOUTH);
        add(canvas, CENTER);
        add(configPanel,NORTH);

        setSize(1000,600);
        setVisible(true);
        pack();
    }
}
