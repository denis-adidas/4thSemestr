public class Main {
    public static void main(String[] args) {

//        Int b = new Int();
//        b.out();
//        b.increment();
//        Int a = new Int();

        fraction a = new fraction(2, 4);
        fraction b = new fraction(3, 5);

        a.mul(b);

        a.out();

//        System.out.println(b.toStr() + a.toStr() + a.toStr() + a.toStr());
    }
}
