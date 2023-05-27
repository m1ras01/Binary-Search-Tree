public class Main {
    public static void main(String[] args) {
        BST<Integer,String> a = new BST<>();
        a.put(25, "nine");
        a.put(15, "two");
        a.put(50, "eight");
        a.put(10, "one");
        a.put(22, "three");
        a.put(35, "seven");
        a.put(70, "four");
        a.put(4, "six");
        a.put(12, "nine");
        a.put(18, "ten");
        a.put(24, "shantaram");
        a.put(31, "shantaram");
        a.put(44, "shantaram");
        a.put(66, "shantaram");
        a.put(90, "shantaram");

       // System.out.println(a.get(1)); //output: "one"
       // a.delete(1);
        //System.out.println(a.get(1));// output: "null"

        //System.out.println(a.get(0)); // output: "null"

        //a.put(0,"nft");
        //System.out.println(a.get(0)); // output: " nft"

        //System.out.println();

        System.out.println("In order:");
        a.inOrder();
        System.out.println("Pre order");
        a.preOrder();
        System.out.println();
        System.out.println("PostOrder");
        a.postOrder();
        System.out.println();

        System.out.println( a.consist("one"));



    }
}