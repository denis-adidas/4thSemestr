import Matrixes.*;
public class Main {
    public static void main(String[] args) {

        Matrix a = new Matrix(2, 3);
//        Matrix b = new Matrix(2, 2);
        a.setMat(1, 1, 1);
        FourPartMatrix c = new FourPartMatrix(a);

//        a = a.sum(b);

//        SquareMatrix c = new SquareMatrix(6);
        System.out.println(a.toString());
        System.out.println(c.toString());


    }
}