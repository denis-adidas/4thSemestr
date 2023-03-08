import SortedIntegerList.*;
public class Main {
    public static void main(String[] args) {
        SortedIntegerList a = new SortedIntegerList(false);
        SortedIntegerList b = new SortedIntegerList(false);
        System.out.println(a.equal(b));
        a.add(5);
        a.add(1);
        a.add(5);
        a.add(6);
        a.add(2);
        b = a.getLessThan(5);
//        a.remove(5);
        System.out.println(a.toString());
        System.out.println(b.toString());


    }
}