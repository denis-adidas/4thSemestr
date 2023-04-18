package Matrixes.Knapsack;

public class Knapsack {
private int [] values;
private int[] weights;
final int maxCapacity;

public Knapsack(int [] weights, int [] values, int maxCapacity) {
    this.weights = weights;
    this.values = values;
    this.maxCapacity = maxCapacity;
}
    public int [] getWeights() {
        return weights;
    }

    public int[] getValues() {
        return values;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
    public int size() {
        return weights.length;
    }
}
