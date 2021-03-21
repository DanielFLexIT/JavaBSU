import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyMouseMotionListener implements MouseMotionListener {
    private StatusBar statusBar;
    private JButton button_;
    public MyMouseMotionListener(StatusBar statusBar, JButton button){
        this.statusBar = statusBar;
        this.button_ = button;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.isControlDown()){
            button_.setLocation(e.getX() , e.getY());
            statusBar.setMessage("Current mouse position " +  e.getX() + " х " + e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.statusBar.setMessage("Current mouse position " +  e.getX() + " х " + e.getY());
    }
}