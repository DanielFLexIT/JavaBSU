public class Student {
    private Integer id;
    private String surname;
    private Integer course;
    private Integer group;

    public Student(){}

    public Student(int id_, String surname_, int course_, int group_){
        id = id_;
        surname = surname_;
        course = course_;
        group = group_;
    }

    //Getters
    public Integer getId(){
        return this.id;
    }

    public String getSurname(){
        return this.surname;
    }

    public Integer getCourse(){
        return this.course;
    }

    public Integer getGroup(){
        return this.group;
    }

    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return id + " " + surname + " " + course + " " + group;
    }

    public String toXMLString(){
        return "\t<student id = " + "\"" + getId()  + "\"" +  " name = " + "\"" +  getSurname() + "\"" + " course = " + "\"" + getCourse() + "\"" + " group = " +  "\"" + getGroup() + "\"" + "/>\n";
    }
}
