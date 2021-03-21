import org.xml.sax.SAXException;

import java.util.*;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class View extends JFrame {

    private JList<Student> leftList = new JList<>();
    private JList<Student> rightList = new JList<>();
    private Model model;

    View(String app)  {
        super(app);
        this.model = new Model();
        leftList.setModel(model.getModel());
        rightList.setModel(model.getResultModel());
        this.setSize(500,500);
        JPanel mainPanel = new JPanel(new BorderLayout());
        addComponents(mainPanel);
        this.setContentPane(mainPanel);
        this.setVisible(true);

    }

    private void addComponents(JPanel panel){
        panel.add(leftList, BorderLayout.WEST);
        panel.add(rightList, BorderLayout.EAST);
        JPanel centralPanel = new JPanel(new GridLayout(5,1));
        JButton openXmlButton = new JButton("Open xml file");
        openXmlButton.addMouseListener(new OpenButtonListener());
        centralPanel.add(openXmlButton);
        JButton openTxtButton = new JButton("Open txt file");
        openTxtButton.addMouseListener(new OpenTxtButtonListener());
        centralPanel.add(openTxtButton);
        JButton chooseGroup = new JButton("Choose course");
        chooseGroup.addMouseListener(new ChooseButtonListener(model));
        centralPanel.add(chooseGroup);
        JButton addStudent = new JButton("Add student");
        addStudent.addMouseListener(new AddButtonListener());
        centralPanel.add(addStudent);
        JButton saveButton = new JButton("Save file");
        saveButton.addMouseListener(new SaveButtonListen());
        centralPanel.add(saveButton);
        panel.add(centralPanel, BorderLayout.CENTER);
    }
    private class SaveButtonListen extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("./res/"));
            int result = chooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                File targetFile = chooser.getSelectedFile();
                try {
                    if (!targetFile.exists()) {
                        targetFile.createNewFile();
                    }
                    XMLSaver saver = new XMLSaver(model.getResultModel());
                    //saver.saveAutomatic(targetFile);
                    saver.saveManual(targetFile);
                }
                catch (IOException exception){
                    JOptionPane.showMessageDialog(null, "Error with file");
                } catch (ParserConfigurationException parserConfigurationException) {
                    JOptionPane.showMessageDialog(null, "Error with data");
                } catch (TransformerConfigurationException transformerConfigurationException) {
                    JOptionPane.showMessageDialog(null, "Error with parser");
                } catch (TransformerException transformerException) {
                    JOptionPane.showMessageDialog(null, "Error with saving to file");
                }

            }
        }
    }
    private class OpenButtonListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose file ");
            fileChooser.setCurrentDirectory(new File("./res/"));
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                XMLReader reader = new XMLReader();
                try {
                    model.setModel(reader.ReadData(file));
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                } catch (SAXException saxException) {
                    saxException.printStackTrace();
                } catch (ParserConfigurationException parserConfigurationException) {
                   JOptionPane.showMessageDialog(null,"Error");
                }
            }
        }
    }
    private class OpenTxtButtonListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose file ");
            fileChooser.setCurrentDirectory(new File("./res/"));
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                TXTReader txtReader = new TXTReader();
                try {
                    model.setModel(txtReader.readFile(file));
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                catch (InputMismatchException exception){
                    JOptionPane.showMessageDialog(null, "Incorrect inputing");
                }
            }
        }
    }
    private class AddButtonListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            Dialog addStudent = new Dialog("Dialog window", model);
        }
    }
    private class ChooseButtonListener extends MouseAdapter{
        private JTextField field = new JTextField();
        private Model model;
        private JFrame frame;
        ChooseButtonListener(Model model_){
            this.model = model_;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            frame = new JFrame();
            frame.setTitle("Choose course");
            JPanel panel = new JPanel(new GridLayout(2,1));
            frame.setSize(300,300);
            JButton submitButton = new JButton("Submit");
            submitButton.addMouseListener(new SubmitButtonListener());
            panel.add(field);
            panel.add(submitButton);
            frame.setContentPane(panel);
            frame.setVisible(true);
        }

        private class SubmitButtonListener extends MouseAdapter{
            @Override
            public void mouseClicked(MouseEvent e) {
                model.Clear();
                try {
                    int selectedGroup = Integer.parseInt(field.getText());
                    model.setSelectedGroup(selectedGroup);
                    DefaultListModel<Student> students = new DefaultListModel<>();
                    List<Student> list = model.getArrayListModel();
//                list.stream().sorted((s1, s2) -> {
//                    if (!s1.getGroup().equals(s2.getCourse())){
//                        return s1.getGroup().compareTo(s2.getGroup());
//                    }
//                    else{
//                        return s1.getSurname().compareTo(s2.getSurname());
//                    }
//                }).forEach(students::addElement);
                    List<Student> copy = new ArrayList<>(list);
                    copy.sort(Comparator.comparing(Student::getGroup).thenComparing(Student::getSurname));
                    model.setListResultModel(copy);
                    frame.setVisible(false);
                }
                catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(null, "Incorrect inputing");
                }
                catch (NoSuchElementException exception){
                    JOptionPane.showMessageDialog(null, "Empty field");
                }
            }
        }
    }
};
