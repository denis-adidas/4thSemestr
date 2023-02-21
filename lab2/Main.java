public class Main {
    public static void main(String[] args) {

        matrix a = new matrix(3);
        a.setMat(0, 1, 3);

        matrix b = new matrix(3);
        b.setMat(0, 1, 3);

        System.out.println(a.toString());


//        for (int i = 1; i < 10; i++) {
//            a = a.product(b);
//            System.out.println(a.toString());
//        }
        a.doMiracle(1);
        System.out.println(a.toString());

        b.doMiracle(0);
        System.out.println(b.toString());


    }
}
//отобраение отнсоительно главной и побочной