import java.security.Key;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class BST<K extends Comparable<K>,V> {
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int size;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.size = 1;
        }
    }

    public BST() {
        root = null;
    }

    public void put(K key, V value) {
        if (key == null || value == null) {
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) return new Node(key, value);
        int cpm = key.compareTo(node.key);
        if (cpm < 0) {
            node.left = put(node.left, key, value);
        } else if (cpm > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.size = 1 + size(node.right) + size(node.left);
        return node;
    }

    public V get(K key) {
        Node node = get(root, key);
        if (node == null) return null;
        return node.value;
    }

    private Node get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return get(node.right, key);
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return node;
        }
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            node.right = delete(node.right, key);
        } else if (cmp < 0) {
            node.left = delete(node.left, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println("Key: " + node.key + " Value: " + node.value);
        inOrder(node.right);
    }

    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null) return;
        System.out.print(node.key+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key + " ");
    }

    public boolean consist(V value){
        return consist(value,root);
    }
    private boolean consist(V value,Node node){

        if (node==null) return false;
        if (node.value.equals(value)) return true;

        boolean left = consist(value, node.left);
        boolean right = consist(value, node.right);

        return left || right;
    }

    public Iterator<K> iterator(){
        return new Iterator<>() {
            private Node current = root;
            private final Stack<Node> stack = new Stack<>();

            @Override
            public boolean hasNext(){
                return current != null || !stack.isEmpty();
            }
            @Override
            public K next() {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                K key = current.key;
                current = current.right;
                return key;
            }
        };
    }


    public int size(){
        return size(root);
    }
    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node node){
        if(node == null) return null;
        if(node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.size = 1+ size(node.left)+ size(node.right);
        return node;
    }
    private Node min(Node node){
        if(node.left == null) return node;
        return min(node.left);
    }


}
