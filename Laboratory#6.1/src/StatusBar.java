import javax.swing.*;

public class StatusBar extends JLabel {
    public StatusBar() {
        super();
        super.setSize(400, 50);
        setMessage("");
    }

    public void setMessage(String message) {
        setText(" " + message);
    }
}
