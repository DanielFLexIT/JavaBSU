import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        File in = new File("src/input.txt");
        Scanner scanner = new Scanner(in);
        int numOfMatrixes = scanner.nextInt();
        Set set = new TreeSet();
        while (scanner.hasNext()){
            set.add(scanner.nextInt());
        }
        System.out.println(set.);
    }
}
