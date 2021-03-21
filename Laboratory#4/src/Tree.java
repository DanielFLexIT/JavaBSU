import java.util.function.Consumer;

public class Tree<T extends Comparable<T>>{

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

    private Node root = null;
    public Tree(){
        root = null;
    }
    public Tree(T[] array){
        for (T element: array){
            Add(element);
        }
    }

    public boolean find(T value) {
        Node current = root;
        while (true) {
            if (current == null) return false;
            if (current.key.compareTo(value) > 0) {
                current = current.left;
            }
            else if (current.key.compareTo(value) < 0) {
                current = current.right;
            }
            else return true;
        }
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


    public void Add(T element) {
        root = doAdd(root, element);
    }


    private Node doDelete(Node node, T key_){
        if (node == null){
            return null;
        }
        if (node.key.compareTo(key_) == 0){
            //leaf
            if((node.left == null) && (node.right == null)){
                return null;
            }
            //one son
            if (node.right == null){
                return node.left;
            }
            if (node.left == null){
                return node.right;
            }
            //two sons????
        }

        if (node.key.compareTo(key_) > 0){
            node.left = doDelete(node.left, key_);
            return node;
        }

        node.right = doDelete(node.right, key_);
        return node;
    }

    public void Delete(T element){
        root = doDelete(root, element);
    }

    public Tree<T> getLeft() {
        if (root == null) throw new IllegalStateException("Binary tree is empty");
        Tree<T> result = new Tree<>();
        result.root = root.left;
        return result;
    }

    public Tree<T> getRight() {
        if (root == null) throw new IllegalStateException("Binary tree is empty");
        Tree<T> result = new Tree<>();
        result.root = root.right;
        return result;
    }

    //left-root-right
    public void traverseInOrder(Consumer<T> function) {
        if (root == null) return;
        getLeft().traverseInOrder(function);
        function.accept(root.key);
        getRight().traverseInOrder(function);
    }

    //root-left-right
    public void traversePreOrder(Consumer<T> function) {
        if (root == null) return;
        function.accept(root.key);
        getLeft().traversePreOrder(function);
        getRight().traversePreOrder(function);

    }

    //left-right-root
    public void traversePostOrder(Consumer<T> function) {
        if (root == null) return;
        getLeft().traversePostOrder(function);
        getRight().traversePostOrder(function);
        function.accept(root.key);
    }
}
