import javax.swing.*;
import java.awt.*;

public class ThirdTask extends JPanel{
    String desktop = System.getProperty("user.home") + "/Desktop/BSU/Programming/";
    ImageIcon selectedIcon = new ImageIcon(desktop + "icon4.png");
    ImageIcon hoverIcon = new ImageIcon(desktop + "icon2.png");
    ImageIcon realizedIcon = new ImageIcon(desktop + "icon1.png");
    ImageIcon pressedIcon = new ImageIcon(desktop + "icon3.png");
    public ThirdTask(LayoutManager manager){
        super(manager);
        JRadioButton leftButton = new JRadioButton("Left Button");
        changeBehaviorOfButton(leftButton);
        JRadioButton rightButton = new JRadioButton("Right Button");
        changeBehaviorOfButton(rightButton);
        JRadioButton highButton = new JRadioButton("High Button");
        changeBehaviorOfButton(highButton);
        JRadioButton lowButton = new JRadioButton("Low Button");
        changeBehaviorOfButton(lowButton);

        this.add(leftButton, BorderLayout.WEST);
        this.add(rightButton, BorderLayout.EAST);
        this.add(highButton, BorderLayout.NORTH);
        this.add(lowButton, BorderLayout.SOUTH);
    }

    public void changeBehaviorOfButton(JRadioButton button){
        button.setIcon(realizedIcon);
        button.setSelectedIcon(selectedIcon);
        button.setPressedIcon(pressedIcon);
        button.setRolloverIcon(hoverIcon);
        button.setHorizontalAlignment(JRadioButton.CENTER);
        button.setVerticalAlignment(JRadioButton.CENTER);
    }
}
