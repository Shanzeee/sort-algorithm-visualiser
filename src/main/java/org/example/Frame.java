package org.example;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    SortingArray panel = new SortingArray();

    public Frame() {
        this.setTitle("Sort Algorithm Visualiser");
        this.getContentPane().setPreferredSize(new Dimension(1400, 700));
        this.getContentPane().add(panel);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panel);
    }
}
