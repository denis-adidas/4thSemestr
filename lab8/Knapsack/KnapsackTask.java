package Matrixes.Knapsack;
public class KnapsackTask {
    static int[] weight = {4, 1, 3};
    static int[] values = {4000, 2000, 2500};

//    public static void main(String[] args) {
//        System.out.println(KnapsackSolution(weight, values, 4));
//    }

    public static int KnapsackSolution(int[] weights, int[] values, int maxCapacity) {

        int[][] arr = new int[weights.length + 1][maxCapacity + 1];
        for (int i = 0; i <= weights.length; i++) {
            for (int j = 0; j <= maxCapacity; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                } else {
                    if (weights[i - 1] > j) {
                        arr[i][j] = arr[i - 1][j];
                    } else {
                        int prev = arr[i - 1][j];
                        int byFormula = values[i - 1] + arr[i - 1][j - weights[i - 1]];
                        arr[i][j] = Math.max(prev, byFormula);
                    }
                }
            }
        }
        return arr[weights.length][maxCapacity];
    };
}
