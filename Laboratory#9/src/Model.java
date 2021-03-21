import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private DefaultListModel<Student> model;
    private DefaultListModel<Student> resultModel;
    private int selectedCourse;

    public Model() {
       model = new DefaultListModel<>();
       resultModel = new DefaultListModel<>();
    }

    public DefaultListModel<Student> getModel() {
        return model;
    }

    public ArrayList<Student> getArrayListModel(){
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < model.size(); ++i){
            if (model.get(i).getCourse() == selectedCourse) {
                students.add(model.get(i));
            }
        }
        return students;
    }

    public void setSelectedGroup(int selectedGroup) {
        this.selectedCourse = selectedGroup;
    }

    public void setListResultModel(List<Student> resultModel){
        for (Student student : resultModel) {
            this.resultModel.addElement(student);
        }
    }

    public DefaultListModel<Student> getResultModel() {
        return resultModel;
    }

    public void setModel(DefaultListModel<Student> model) {
        for (int i = 0; i < model.size(); ++i){
            this.model.addElement(model.get(i));
        }
    }

    public void setResultModel(DefaultListModel<Student> resultModel) {
        for (int i = 0; i < resultModel.size(); ++i){
            this.resultModel.addElement(resultModel.get(i));
        }
    }

    public void Clear(){
        resultModel.clear();
    }

}
