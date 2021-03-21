package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Опросник позитивный");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800,500));

        JPanel panel = new JPanel(null);
        JLabel label = new JLabel("Радует ли Вас размер зарплаты?");
        label.setSize(new Dimension(300,30));
        label.setLocation(300,100);
        panel.add(label);

        JButton button1 = new JButton("Да");
        button1.setSize(new Dimension(100,30));
        button1.setLocation(250,150);
        panel.add(button1);

        JButton button2 = new JButton("Не очень");
        button2.setSize(new Dimension(100,30));
        button2.setLocation(450,150);
        panel.add(button2);

        MyMouseListener listener = new MyMouseListener(button1);
        button1.addMouseListener(listener);

        MyMouseMotionListener listener1 = new MyMouseMotionListener(button2);
        button2.addMouseMotionListener(listener1);

        frame.setContentPane(panel);
        frame.setVisible(true);

    }
}
