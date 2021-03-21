import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.NoSuchElementException;
import javax.swing.*;

public class SimpleGUI extends JFrame {
    private final JTextField input = new JTextField("");
    private final JTextField num = new JTextField("");
    private final JTextField coeff = new JTextField("");
    private final JTextField string = new JTextField("");
    private final JTextField j = new JTextField("");
    private final JRadioButton liner = new JRadioButton("Liner");
    private final JRadioButton exponential = new JRadioButton("Exponential");
    private Series series;
        public SimpleGUI() {
            super("Series PRO");
            this.setBounds(400,400,700,400);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Container container = this.getContentPane();
            container.setLayout(new GridLayout(6,5,3,3));
            container.add(input);
            JLabel firstElement = new JLabel("First element");
            container.add(firstElement);
            container.add(num);
            JLabel numOfElements = new JLabel("Number of elements");
            container.add(numOfElements);
            container.add(coeff);
            JLabel coefficient = new JLabel("Coefficient");
            container.add(coefficient);
            JLabel string_ = new JLabel("Choose the name of File");
            container.add(string_);
            container.add(string);

            ButtonGroup group = new ButtonGroup();
            group.add(liner);
            group.add(exponential);
            container.add(liner);
            liner.setSelected(true);
            container.add(exponential);
            JButton sum = new JButton("Calculate");
            sum.addActionListener(new ButtonEventListener());
            container.add(sum);
            container.add(j);
        }

        class ButtonEventListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String message = "";
                if (liner.isSelected()) {
                    try{
                        series = new Liner(Double.parseDouble(coeff.getText()),Double.parseDouble(input.getText()), Integer.parseInt(num.getText()));
                        int getElement = Integer.parseInt(j.getText());
                        String str = string.getText();
                        message += "Sum is " + series.sum(Integer.parseInt(num.getText())) + '\n';
                        message += "Item at " + j.getText() + " position is " + series.getElement(getElement) + '\n';
                        message += series.toString();
                        series.saveToFile(str, Integer.parseInt(num.getText()) );
                    }
                    catch (NumberFormatException | IOException ex){
                        message = ex.getMessage();
                    }

                }
                else if (exponential.isSelected()){
                    try {
                        series = new Exponential(Double.parseDouble(coeff.getText()), Double.parseDouble(input.getText()), Integer.parseInt(num.getText()));
                        int getElement = Integer.parseInt(j.getText());
                        String str = string.getText();
                        message += "Sum is " + series.sum(Integer.parseInt(num.getText())) + '\n';
                        message += "Item at " + j.getText() + " position is " + series.getElement(getElement) + '\n';
                        message += series.toString();
                        series.saveToFile(str, Integer.parseInt(num.getText()) );
                    }
                    catch (NumberFormatException | IOException ex){
                        message = ex.getMessage();
                    }
                }
                JOptionPane.showMessageDialog(null,
                        message,
                        "SERIES",
                        JOptionPane.PLAIN_MESSAGE);

            }
        }

        public static void main(String[] args) {
            SimpleGUI app = new SimpleGUI();
            app.setVisible(true);
        }
    }
