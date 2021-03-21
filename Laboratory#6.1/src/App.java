/**
 * 1.	Реализовать приложение, обладающее следующей функциональностью:
 * •	в окне есть одна кнопка;
 * •	координаты мыши отображаются в строке состояния, находящейся внизу окна;
 * •	щелчок мышью отображает кнопку в позиции щелчка;
 * •	возможен drag&drop кнопки с нажатым Ctrl; (обращать внимание, что координаты мыши в строке состояния должны также изменяться вне зависимости от нажатия Ctrl)
 * •	возможно добавление символов в текст кнопки, а также посредством Backspace удалять последний символ.
 */
import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab06");
        frame.setMinimumSize(new Dimension(800, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);

        JButton button = new JButton("Button");
        button.setLocation(50,50);
        button.setSize(100,20);
        panel.add(button);

        StatusBar statusBar = new StatusBar();
        statusBar.setLocation(0, frame.getSize().height - 60);
        panel.add(statusBar);

        MyMouseMotionListener listener = new MyMouseMotionListener(statusBar,button);
        panel.addMouseMotionListener(listener);

        MyMouseListener listener1 = new MyMouseListener(button);
        panel.addMouseListener(listener1);

        MyKeyListener listener2 = new MyKeyListener(button);
        button.addKeyListener(listener2);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
