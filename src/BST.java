public class BST<K extends Comparable<K>,V> {
    private Node root;
    private class Node{
        private K key;
        private V value;
        private Node left,right;
        private int size;
        public Node(K key,V value){
            this.key = key;
            this.value = value;
            this.size = 1;
        }
    }

    public BST(){
        root = null;
    }
    public void put(K key,V value){
        if(key == null || value == null) {
            return;
        }
        root = put(root,key , value);
    }
    private Node put(Node node, K key , V value){
        if(node == null) return new Node(key,value);
        int cpm = key.compareTo(node.key);
        if(cpm < 0){
            node.left = put(node.left,key,value);
        }
        else if(cpm > 0){
            node.right = put(node.right,key,value);
        }
        else{
            node.value = value;
        }
        node.size = 1 + size(node.right) + size(node.left);
        return node;
    }

    public V get(K key){
        Node node = get(root,key);
        if(node == null) return null;
        return node.value;
    }
    private Node get(Node node,K key){
        if(node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp > 0){
            return get(node.right,key);
        } else if (cmp<0) {
            return get(node.left,key);
        }
        else{
            return node;
        }
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
