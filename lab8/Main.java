import Matrixes.MeasureTime;
import Matrixes.UsualMatrix;

public class Main {
    public static void main(String[] args) {

        UsualMatrix a = new UsualMatrix(512, 512);
        UsualMatrix b = new UsualMatrix(512, 512);
        UsualMatrix c = new UsualMatrix(512, 512);
        UsualMatrix d = new UsualMatrix(512, 512);

        MeasureTime.measureTime("Standart multiplication", () -> {
            c.product(d);
        }, 1);

        ParallelMatrixProduct cd = new ParallelMatrixProduct(128);

        MeasureTime.measureTime("Parallel multiplication", () -> {
            cd.product(a, b);
        }, 1);
        System.out.println("matrices are equal: " + c.equals(d));
    }
}