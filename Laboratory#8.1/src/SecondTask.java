import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.awt.Color.RED;
import static java.awt.Color.yellow;

public class SecondTask extends JPanel {
        public SecondTask(LayoutManager manager){
            super(manager);
            GridLayout layout = (GridLayout)manager;
            ButtonClickListener listener = new ButtonClickListener();
            for (int i = 0; i < layout.getRows(); i++){
                for (int j = 0; j < layout.getColumns(); j++){
                    JButton button = new JButton("Button");
                    button.setBackground(yellow);
                    button.setOpaque(true);
                    button.setBorderPainted(false);
                    button.addMouseListener(listener);
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
}
