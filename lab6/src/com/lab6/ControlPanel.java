package com.lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn= new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {

        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        loadBtn.addActionListener(this::load);
        saveBtn.addActionListener(this::save);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);

    }
    private void save(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
            ImageIO.write(frame.canvas.image, "PNG", fileChooser.getSelectedFile());}
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void load(ActionEvent e)
    {
        try{
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                frame.remove(frame.canvas);
                frame.canvas=new DrawingPanel(frame,ImageIO.read(fileChooser.getSelectedFile()));
                frame.add(frame.canvas);
                frame.setVisible(true);
            }
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

    }
    private void reset(ActionEvent e)
    {
        try{
            frame.remove(frame.canvas);
            frame.canvas=new DrawingPanel(frame);
            frame.add(frame.canvas);
            frame.setVisible(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    private void exit(ActionEvent e)
    {
        System.exit(0);
    }

}