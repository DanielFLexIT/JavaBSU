package com.daniel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App extends JFrame {

    public JFrame frame;
    private JButton open;
    private JButton save;
    int width = (int) (1980 / (1.5));
    int height = (int) (1100 / 1.5);

    public MyPanel drawingPanel;
    public JScrollPane pane;
    private JRadioButton red;
    private JRadioButton green;
    private JRadioButton blue;
    private JPanel panel1;
    private Color color;
    private JFileChooser fileChooser;
    private File file;

    public int xOld;
    public int yOld;
    public int xNew;
    public int yNew;

    public App(){
        super("Laboratory #7");
        setSize(800,600);

        drawingPanel = new MyPanel();
        panel1 = new JPanel(new GridLayout(2,3));

        save = new JButton("Save");
        open = new JButton("Open");

        ButtonGroup colorGroup = new ButtonGroup();
        red = new JRadioButton("Red");
        colorGroup.add(red);
        color = Color.red;
        red.setSelected(true);
        green = new JRadioButton("Green");
        colorGroup.add(green);
        blue = new JRadioButton("Blue");
        colorGroup.add(blue);

        panel1.add(red);
        panel1.add(blue);
        panel1.add(green);
        panel1.add(save);
        panel1.add(open);

        pane = new JScrollPane(drawingPanel);
        pane.setPreferredSize(new Dimension(width, height));
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pane, BorderLayout.CENTER);
        getContentPane().add(panel1,BorderLayout.SOUTH);

        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        drawingPanel.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                xOld = e.getX();
                yOld = e.getY();
            }
        });

        drawingPanel.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                xNew = e.getX();
                yNew = e.getY();
                
                Graphics g = drawingPanel.getGraphics();
                Graphics buf = drawingPanel.getBuffer().getGraphics();
                chooseColor();
                buf.setColor(color);
                g.setColor(color);

                buf.drawLine(xOld, yOld, xNew, yNew);
                g.drawLine(xOld, yOld, xNew, yNew);

                xOld = xNew;
                yOld = yNew;
            }
        });

        drawingPanel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                Graphics g = drawingPanel.getGraphics();
                Graphics buf = drawingPanel.getBuffer().getGraphics();
                chooseColor();
                buf.setColor(color);
                g.setColor(color);

                g.fillRect(e.getX(), e.getY(), 1, 1);
                buf.fillRect(e.getX(), e.getY(), 1, 1);
            }
        });

        open.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                fileChooser.setDialogTitle("Choose image ");
                int returnValue = fileChooser.showOpenDialog(App.this);
                if (returnValue == JFileChooser.APPROVE_OPTION){
                    file = fileChooser.getSelectedFile();
                    try{
                        BufferedImage buf = ImageIO.read(file);
                        drawingPanel.loadImage(buf);
                    } catch (IOException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });

        save.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                fileChooser.setDialogTitle("Save image ");
                int ret = fileChooser.showSaveDialog(null);
                file = fileChooser.getSelectedFile();
                if (ret == fileChooser.APPROVE_OPTION){
                    try{
                        ImageIO.write(drawingPanel.getBuffer(), "png", file);

                    } catch (IOException ex){
                        ex.getMessage();
                    }
                }
            }
        });

    }

    public void chooseColor(){
        if (red.isSelected()){
            color = Color.RED;
        } else if (green.isSelected()){
            color = Color.GREEN;
        } else if (blue.isSelected()){
            color = Color.BLUE;
        }
}
};
