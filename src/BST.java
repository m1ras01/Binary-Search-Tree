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
        if(key == null && value == null) {
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
        node.size = 1 + node.right.size + node.left.size;
        return node;
    }
}
