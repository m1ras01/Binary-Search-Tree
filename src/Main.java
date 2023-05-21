public class Main {
    public static void main(String[] args) {
        BST<Integer,String> a = new BST<>();
        a.put(5, "five");
        a.put(2, "two");
        a.put(8, "eight");
        a.put(1, "one");
        a.put(3, "three");
        a.put(7, "seven");
        a.put(4, "four");
        a.put(6, "six");
        a.put(9, "nine");
        a.put(10, "ten");
        a.put(10, "shantaram");

        System.out.println(a.get(1)); //output: "one"
        a.delete(1);
        System.out.println(a.get(1));// output: "null"

        System.out.println(a.get(0)); // output: "null"
        a.put(0,"nft");
        System.out.println(a.get(0)); // output: " nft"

        System.out.println();

        a.inOrder();





    }
}