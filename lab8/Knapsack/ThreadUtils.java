package Matrixes.Knapsack;

public class ThreadUtils {
    public static final int NUM_THREAD = 4;

    public void runThread(Knapsack knapsack, int [] solutions) {
        Thread [] threads = new Thread[NUM_THREAD];
        for (int i = 0; i < NUM_THREAD; i++) {
            threads[i] = new Thread(new KnapsackThreadSolution(knapsack, solutions, i));
            threads[i].start();
        }
        try {
            for (int i = 0; i < NUM_THREAD; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
