import Matrixes.Knapsack.Knapsack;
import Matrixes.Knapsack.KnapsackTask;
import Matrixes.Knapsack.ThreadUtils;
import Matrixes.MeasureTime;
import Matrixes.UsualMatrix;

import java.security.MessageDigest;

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
        System.out.println(cd.toString());

//        int[] weights = {4, 1, 3};
//        int[] values = {4000, 2000, 2500};
//        int capacity = 4;
//        Knapsack knapsack = new Knapsack(weights, values, capacity);
//        int[] solutions = new int[capacity + 1];
//        ThreadUtils tu = new ThreadUtils();
//        MeasureTime.measureTime("Thread solution", () -> {
//            tu.runThread(knapsack, solutions);
//        }, 1);
////        System.out.println("The maximum value that can be put in a knapsack of capacity " + capacity + " is " + solutions[capacity]);
//
//        MeasureTime.measureTime("Standart solution", () -> {
//            KnapsackTask.KnapsackSolution(weights, values, capacity);
//        }, 1);
    }
}