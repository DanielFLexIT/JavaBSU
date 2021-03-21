package com.company;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
public class MyMouseMotionListener implements MouseMotionListener {

    private JButton button ;
    public MyMouseMotionListener(JButton button_){
        button = button_;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        button.setLocation((int)(Math.random() * 700), (int)(Math.random() * 470));
    }
}
