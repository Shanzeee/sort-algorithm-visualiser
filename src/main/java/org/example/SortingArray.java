package org.example;

import org.example.algorithms.*;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SortingArray extends JPanel implements ActionListener {
    private final int[] array = new int[100];
    private boolean stop = false;
    private final Random random = new Random();
    boolean bubbleBoolean = false;
    boolean cocktailBoolean = false;
    boolean gnomeBoolean = false;
    boolean selectionBoolean = false;
    boolean pancakeBoolean = false;
    BubbleSort bubbleSort = new BubbleSort();
    CocktailSort cocktailSort = new CocktailSort();
    GnomeSort gnomeSort = new GnomeSort();
    SelectionSort selectionSort = new SelectionSort();
    PancakeSort pancakeSort =new PancakeSort();

    JLabel label = new JLabel("0 swaps made  ");
    JButton RESTART = new JButton("restart array");
    JButton BUBBLE = new JButton("bubble sort");
    JButton COCKTAIL = new JButton("cocktail sort");
    JButton GNOME = new JButton("gnome sort");
    JButton SELECTION = new JButton("selection sort");
    JButton PANCAKE = new JButton("pancake sort");

    public SortingArray(){
        randomizeArrayPosition();
        this.add(label);
        label.setForeground(Color.RED);
        createButton(RESTART, "restart");
        createButton(BUBBLE, "bubble");
        createButton(COCKTAIL, "cocktail");
        createButton(GNOME, "gnome");
        createButton(SELECTION, "selection");
        createButton(PANCAKE, "pancake");

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.black);
        for (int i = 0; i < array.length; i++) {
            g.setColor(Color.WHITE);
            if (cocktailBoolean){
                if (i==CocktailSort.currIndex){
                    g.setColor(Color.MAGENTA);
                }
                if (i>=array.length - CocktailSort.portionSorted || i<=CocktailSort.forwardPortionSorted){
                    g.setColor(Color.GREEN);
                }
            }

            if (bubbleBoolean) {
                if (i == BubbleSort.currIndex && i != 0) {
                    g.setColor(Color.MAGENTA);
                }
                if (i >= array.length - BubbleSort.portionSorted) {
                    g.setColor(Color.green);
                }
            }
            if (gnomeBoolean){
                if (i==GnomeSort.currIndex){
                    g.setColor(Color.MAGENTA);
                }

            }
            if (selectionBoolean){
                if (i== SelectionSort.minNum){
                    g.setColor(Color.MAGENTA);
                }
                if (i== SelectionSort.current_index){
                    g.setColor(Color.BLUE);
                }
                if (i< SelectionSort.portion_sorted){
                    g.setColor(Color.GREEN);
                }
                if (i== SelectionSort.portion_sorted){
                    g.setColor(Color.ORANGE);
                }

            }
            if (pancakeBoolean) {
                if (!pancakeSort.flip){
                    if (i == getMax(array.length - pancakeSort.portionSorted)) {
                        g.setColor(Color.MAGENTA);
                    }
                    if (i==0){
                        g.setColor(Color.YELLOW);
                    }
                }
                else {
                    if (i==0){
                        g.setColor(Color.MAGENTA);
                    }
                    if (i==pancakeSort.currMax+1) {
                        g.setColor(Color.YELLOW);
                    }

                }
                if (i >= array.length - pancakeSort.portionSorted) {
                    g.setColor(Color.green);
                }
            }
            g.drawRect(i*(14), 700-array[i], 14, array[i]);
            g.fillRect(i*(14), 700-array[i], 14, array[i]);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();

        switch (choice){
            case "restart":
                bubbleSort.reset();
                bubbleBoolean = false;
                cocktailSort.reset();
                cocktailBoolean = false;
                gnomeSort.reset();
                gnomeBoolean = false;
                selectionSort.reset();
                selectionBoolean = false;
                pancakeSort.reset();
                pancakeBoolean = false;
                stop = true;
                randomizeArrayPosition();
                repaint();
                break;
            case "bubble":
                startSorting("bubble");
                break;
            case "cocktail":
                startSorting("cocktail");
                break;
            case "gnome":
                startSorting("gnome");
                break;
            case "selection":
                startSorting("selection");
                break;
            case "pancake":
                startSorting("pancake");

        }

    }

    private void startSorting(String algorithm){
        Timer bubbleTimer;
        bubbleTimer = new Timer(1, e18 -> {
            if (isSorted() || !stop ) {
                ((Timer) e18.getSource()).stop();
            } else {
                switch (algorithm){
                    case "bubble":
                        bubbleBoolean = true;
                        bubbleSort.sort(array);
                        break;
                    case "cocktail":
                        cocktailBoolean = true;
                        cocktailSort.sort(array);
                        break;
                    case "gnome":
                        gnomeBoolean = true;
                        gnomeSort.sort(array);
                        break;
                    case "selection":
                        selectionBoolean = true;
                        selectionSort.sort(array);
                        break;
                    case "pancake":
                        pancakeBoolean = true;
                        pancakeSort.sort(array);

                }
                label.setText(BubbleSort.swaps + " swaps made  ");
                repaint();
            }
        });
        bubbleTimer.start();
    }

    private void randomizeArrayPosition(){
        for (int i = 0; i < array.length; i++) {
            this.array[i] = random.nextInt(600) + 20;
        }
    }

    private void createButton(JButton button,String action){
        button.setFocusable(false);
        button.addActionListener(this);
        button.setActionCommand(action);
        this.add(button);
    }

    private boolean isSorted(){
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }

    public int getMax(int n){
        int index = 0;
        int max = this.array[0];
        for (int i=0; i < n; i++){
            if (this.array[i] > max){
                max = this.array[i];
                index = i;
            }
        }
        return index;
    }


}
