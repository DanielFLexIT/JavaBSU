package App;

public class MyException extends Exception {
    public MyException(String ex) {
        super(ex);
    }

    public MyException() {}

    public void printMessage() {
        System.out.println(super.getMessage());
    }
}
