import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private FirstTask panel = new FirstTask(new BorderLayout());
    private SecondTask panel2 = new SecondTask(new GridLayout(5,5));
    private ThirdTask panel3 = new ThirdTask(new BorderLayout());
    View (String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JTabbedPane mainPane = new JTabbedPane();
        mainPane.addTab("1 task", panel);
        mainPane.addTab("2 task", panel2);
        mainPane.addTab("3 task", panel3);
        mainPanel.add(mainPane);

        this.setContentPane(mainPanel);
        this.setVisible(true);
    }
}
