import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Tree<T extends Comparable<T>> implements Runnable{

    private class Node {
        private T key = null;
        private Node left = null;
        private  Node right = null;
        public Node(T key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    PrintWriter output = new PrintWriter(new File("bst.out"));
    private Node root = null;
    public Tree() throws FileNotFoundException {
        root = null;
    }

    private Node doAdd(Node node, T key_) {
        if (node == null) {
            return new Node(key_);
        }
        if (node.key.compareTo(key_) > 0) {
            node.left = doAdd(node.left, key_);
        } else if (node.key.compareTo(key_) < 0) {
            node.right = doAdd(node.right, key_);
        }
        return node;
    }

    public void insert(T element) {
        root = doAdd(root, element);
    }

    public Boolean isSearchTree(Node root){
        return true;
    }

    public void traversePreOrder(){
        doTranversePreOrder(root, output);
        output.close();
    }

    private void doTranversePreOrder(Node root, PrintWriter file){
        if (root == null){
            return;
        }
        file.write(root.key.toString() + '\n');
        doTranversePreOrder(root.left, file);
        doTranversePreOrder(root.right, file);
    }

    @Override
    public void run() {
        Tree tree = null;
        try {
            tree = new Tree();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner input = null;
        try {
            input = new Scanner(new File("bst.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Integer numOfOperations = input.nextInt();
        int rootKey = input.nextInt();
        while (numOfOperations) {
            tree.insert(input.nextInt());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Thread(null, new Tree<Integer>(),"", 64*1024*1024 ).start();
    }

};
