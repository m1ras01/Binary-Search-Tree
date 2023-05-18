public class Main {
    public static void main(String[] args) {
        BST<Integer,String> a = new BST<>();
        a.put(0,"jsd");
        a.put(1,"skw");

       System.out.println(a.get(1));
        System.out.println(a.get(0));
    }
}