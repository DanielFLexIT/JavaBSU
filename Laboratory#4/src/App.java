import java.util.function.Consumer;

public class App {
public static void main(String[] args) {
    Tree<Integer> tree = new Tree<>(new Integer[]{2, 3});

    Employee Daniel = new Employee(6, "Danila", "Podorovski");
    Employee Ksesha = new Employee(4, "Kseniya", "Shimborskaya");
    Employee Egor = new Employee(8, "Egor", "Kozel");
    Employee Kostya = new Employee(3, "Kostya", "Arabchik");
    Employee Konstantin = new Employee(5, "Konstantin", "Klenitskiy");
    Employee Masha = new Employee(7, "Mariya", "Kozlovskaya");
    Employee Alex = new Employee(9, "Alexey", "Borichevskiy");
    Tree<Employee> listEmployee = new Tree<>(new Employee[]{Daniel, Ksesha, Egor, Kostya, Konstantin, Masha, Alex});

    try{
        Consumer<Integer> print = x -> System.out.print(x + " ");
//        tree.traverseInOrder(print);
//        System.out.println();
//        tree.traversePostOrder(print);
//        System.out.println();
        tree.traversePreOrder(print);
        System.out.println();
//
//        boolean exist = tree.find(5);
//        System.out.println(exist);
//        exist = tree.find(1);
//        System.out.println(exist);
//
//        Consumer<Employee> printEmployee = y -> System.out.print(y + " ");
//        listEmployee.traverseInOrder(printEmployee);

    }
    catch (IllegalStateException | IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
}
