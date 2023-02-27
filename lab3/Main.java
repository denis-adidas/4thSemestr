public class Main {
    public static void main(String[] args) {

        Matrix a = new Matrix(2, 2);
        Matrix b = new Matrix(3, 2);

        a.setMat(1, 1, 1);

        a = a.sum(b);


        System.out.println(a.toString());


    }
}