package Matrixes;

public class Node {
    private int index;
    private int value;

    public Node(int idx, int value) {
        this.index = idx;
        this.value = value;
    }
    int getIndex() {
        return index;
    }
    int getValue() {
        return value;
    }
    void setIndex(int val) {
        this.index = val;
    }
    void setValue(int val) {
        this.value = val;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Index: ").append(index).append(" Value: ").append(value);
        return str.toString();
    }

}
