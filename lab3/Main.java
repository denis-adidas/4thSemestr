import Matrixes.*;
public class Main {
    public static void main(String[] args) {

        Matrix a = new Matrix(4, 2);
        a.setMat(1, 1, 1);

        FourPartMatrix c = new FourPartMatrix(2, 2);
        c.setMat(1, 2, 5);

        SquareMatrix d = new SquareMatrix(2);

        c = c.sum(d);


        System.out.println(a.toString());
        System.out.println(c.toString());


    }
}