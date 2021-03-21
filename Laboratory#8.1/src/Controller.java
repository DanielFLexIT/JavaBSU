import javax.swing.*;

public class Controller {
    private final DefaultListModel<String> list1 = new DefaultListModel<>();
    private final DefaultListModel<String> list2 = new DefaultListModel<>();
    public Controller() {
        list1.addElement("1");
        list1.addElement("2");
        list1.addElement("3");

        list2.addElement("a");
        list2.addElement("b");
        list2.addElement("c");
    }

    public DefaultListModel<String> getList1(){
        return list1;
    }

    public DefaultListModel<String> getList2(){
        return list2;
    }

}
