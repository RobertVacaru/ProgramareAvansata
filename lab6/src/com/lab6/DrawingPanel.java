package com.lab6;

import com.lab6.Shapes.NodeShape;
import com.lab6.Shapes.RegularPolygon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final static int W = 800, H = 600;
    final MainFrame frame;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    List<Shape> shapes = new ArrayList<>();
    int oldX, oldY, currentX, currentY;

    public DrawingPanel(MainFrame frame, BufferedImage image) {
        this.frame = frame;
        this.image = image;
        graphics = this.image.createGraphics();
        init();
    }

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fu

        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color color = new Color(r, g, b);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (Objects.equals(frame.configPanel.modeCombo.getSelectedItem(), "Add")) {
                    drawShape(e.getX(), e.getY());
                } else if (Objects.equals(frame.configPanel.modeCombo.getSelectedItem(), "Remove")) {
                    removeShape(e.getX(), e.getY());
                } else if (Objects.equals(frame.configPanel.modeCombo.getSelectedItem(), "Free Drawing")) {
                    oldX = e.getX();
                    oldY = e.getY();
                }
                repaint();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (frame.configPanel.modeCombo.getSelectedItem() == "Free Drawing") {
                    currentX = e.getX();
                    currentY = e.getY();
                    if (graphics != null) {
                        if (frame.configPanel.colorCombo.getSelectedItem() == "Black") {
                            graphics.setColor(new Color(0, 0, 0));
                        } else {
                            graphics.setColor(color);
                        }
                        graphics.drawLine(oldX, oldY, currentX, currentY);
                        repaint();
                        oldX = currentX;
                        oldY = currentY;
                    }
                }
            }
        });
    }


    private void removeShape(int x, int y) {
        int n = shapes.size() - 1;
        for (int j = n; j >= 0; j--) {
            if (shapes.get(j).contains(x, y)) {
                graphics.setColor(new Color(255, 255, 255));
                graphics.fill(shapes.get(j));
                shapes.remove(shapes.get(j));
                break;
            }
        }
    }

    private void drawShape(int x, int y) {
        int radius = new Random().nextInt(40) + 5;
        int sides = (Integer) frame.configPanel.sidesField.getValue();
        String color = (String) frame.configPanel.colorCombo.getSelectedItem();
        if (Objects.equals(color, "Black"))
            graphics.setColor(new Color(0, 0, 0));
        else if (Objects.equals(color, "Random"))
            graphics.setColor(new Color(new Random().nextInt(128) + 128, new Random().nextInt(128) + 128, new Random().nextInt(128) + 128));
        if (Objects.equals(frame.configPanel.shapeCombo.getSelectedItem(), "Polygon")) {
            graphics.fill(new RegularPolygon(x, y, radius, sides));
            shapes.add(new RegularPolygon(x, y, radius, sides));
        } else if (Objects.equals(frame.configPanel.shapeCombo.getSelectedItem(), "Circle")) {
            graphics.fill(new NodeShape(x, y, radius));
            shapes.add(new NodeShape(x, y, radius));
        }
    }

    @Override
    public void update(Graphics g) {
    } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
