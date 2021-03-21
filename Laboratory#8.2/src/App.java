import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.awt.Color.*;

public class App extends JPanel {
    public App(LayoutManager manager){
        super(manager);
        GridLayout layout = (GridLayout)manager;
        for (int i = 0; i < layout.getRows(); i++){
            for (int j = 0; j < layout.getColumns(); j++){
                JButton button = new JButton("Button");
                button.setBackground(yellow);
                button.setOpaque(true);
                button.setBorderPainted(false);
                button.addMouseListener(new ButtonClickListener());
                this.add(button);
            }
        }
    }
    private static class ButtonClickListener extends MouseAdapter {
        @Override
        public void mouseReleased(MouseEvent e) {
            JButton button = (JButton)e.getSource();
            button.setText("Button");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            JButton button = (JButton)e.getSource();
            button.setText("Clicked!");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton button = (JButton)e.getSource();
            button.setBackground(RED);
            button.setOpaque(true);
            button.setBorderPainted(false);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton button = (JButton)e.getSource();
            button.setBackground(yellow);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        App dialog = new App(new GridLayout(5,5));
        frame.setContentPane(dialog);
        frame.setVisible(true);
    }
}
