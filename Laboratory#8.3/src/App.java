import javax.swing.*;
public class App extends JFrame {
    private JPanel panel;
    private ButtonGroup group;
    private ImageIcon[] icons;
    private JRadioButton[] buttons;
    private int icon = 4;
    App(){
        super("Laboratory#8");
        setSize(500,150);
        panel = new JPanel();
        group = new ButtonGroup();
        icons = new ImageIcon[icon + 1];

        for (int i = 0; i < icon; ++i){
            String desktop = System.getProperty("user.home") + "/Desktop/BSU/Programming/";
            String path = desktop + "icon" + (i + 1) + ".png";
            icons[i] = new ImageIcon(path);
        }
        buttons = new JRadioButton[icon];
        for (int i = 0 ; i < icon ; i++){
            buttons[i] = new JRadioButton();
            buttons[i].setIcon(icons[0]);
            buttons[i].setSelectedIcon(icons[1]);
            buttons[i].setPressedIcon(icons[2]);
            buttons[i].setRolloverIcon(icons[3]);
            group.add(buttons[i]);
            panel.add(buttons[i]);
        }
        setContentPane(panel);
    }
}
