import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FirstTask extends JPanel {
    private final JButton button1 = new JButton("<");
    private final JButton button2 = new JButton(">");
    private final Controller controller = new Controller();
    private final JList<String> list1 = new JList<>(controller.getList1());
    private final JList<String> list2 = new JList<>(controller.getList2());

    public FirstTask(LayoutManager manager){
        super(manager);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(button1, BorderLayout.SOUTH);
        panel.add(button2, BorderLayout.NORTH);
        this.add(list1, BorderLayout.EAST);
        this.add(list2, BorderLayout.WEST);
        this.add(panel, BorderLayout.CENTER);
        MyClickListener listener = new MyClickListener();
        button1.addMouseListener(listener);
        button2.addMouseListener(listener);
    }

    private class MyClickListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            if (button == button1) {
                if (!list1.isSelectionEmpty()) {
                    int[] indexes = list1.getSelectedIndices();
                    for (int i = 0; i < indexes.length; ++i) {
                        controller.getList2().addElement(controller.getList1().getElementAt(indexes[i]));
                    }
                    for (int i = 0; i < indexes.length; ++i) {
                        controller.getList1().removeElementAt(indexes[i] - i);
                    }
                }
            }
                if (button == button2) {
                    if (!list2.isSelectionEmpty()) {
                        int[] indexes = list2.getSelectedIndices();
                        for (int i = 0; i < indexes.length; ++i) {
                            controller.getList1().addElement(controller.getList2().getElementAt(indexes[i]));
                        }
                        for (int i = 0; i < indexes.length; ++i) {
                            controller.getList2().removeElementAt(indexes[i] - i);
                        }
                    }
                }
            }
        }
    }


