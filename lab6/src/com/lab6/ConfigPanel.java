package com.lab6;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox<Color> colorCombo; // the color of the shape
    JButton newColorBtn = new JButton("+");
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
         sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        //create the colorCombo, containing the values: Random and Black
       colorCombo=new JComboBox<Color>();
       colorCombo.addItem(new Color(0,0,0));
       colorCombo.addItem(new Color(new Random().nextInt(128)+128,new Random().nextInt(128)+128,new Random().nextInt(128)+128));
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);
    }
}
