package com.lab6;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel, shapeLabel, colorLabel, modeLabel; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox<String> colorCombo, shapeCombo, modeCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        modeLabel = new JLabel("Action:");
        modeCombo = new JComboBox<>();
        modeCombo.addItem("Add");
        modeCombo.addItem("Remove");
        modeCombo.addItem("Free Drawing");
        //create the label and the spinner
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides

        shapeLabel = new JLabel("The shape you are using:");
        shapeCombo = new JComboBox<>();
        shapeCombo.addItem("Circle");
        shapeCombo.addItem("Polygon");

        //create the colorCombo, containing the values: Random and Black
        colorLabel = new JLabel("Color of shape:");
        colorCombo = new JComboBox<
                >();
        colorCombo.addItem("Black");
        colorCombo.addItem("Random");

        add(modeLabel);
        add(modeCombo);
        add(shapeLabel);
        add(shapeCombo);
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorLabel);
        add(colorCombo);
    }
}
