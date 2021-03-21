public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private String surname;
    public Employee(int i, String name_, String surname_) {id = i; name = name_; surname = surname_;}
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("ID: " + Integer.toString(id) + " Name: " + name + " Surname: " + surname);
        return buf.toString();
    }
    public int compareTo(Employee p){
        return Integer.compare(id, p.id);
    }
}
