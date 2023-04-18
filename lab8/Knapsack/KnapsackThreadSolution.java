package Matrixes.Knapsack;

public class KnapsackThreadSolution implements Runnable {

    private int [] arr;
    private Knapsack knapsack;
    private int threadNum = 4;
    public KnapsackThreadSolution(Knapsack knapsack, int [] solutions, int runThreads) {
        this.knapsack = knapsack;
        this.arr = solutions;
        this.threadNum = runThreads;
    }

    @Override
    public void run() {
        for (int i = threadNum; i < knapsack.size(); i += ThreadUtils.NUM_THREAD) {
            int weight = knapsack.getWeights()[i];
            int value = knapsack.getValues()[i];
            for (int j = knapsack.getMaxCapacity(); j >= weight; j--) {
                int prevSolution = (i == 0) ? 0 : arr[j];
                int newSolution = arr[j - weight] + value;
                arr[j] = Math.max(prevSolution, newSolution);
            }
        }
    }
}
