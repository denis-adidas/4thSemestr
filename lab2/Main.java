public class Main {
    public static void main(String[] args) {

        matrix a = new matrix(2);
        a.setMat(1, 1, 0);
        matrix b = a;
        System.out.println(a.toString());


        for (int i = 1; i < 10; i++) {
            a = a.product(b);
            System.out.println(a.toString());
        }


    }
}