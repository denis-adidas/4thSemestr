import Matrixes.*;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Node> table[] = new LinkedList[5];
        Node testN = new Node(0, 5);
        table[0] = new LinkedList<Node>();
        table[0].add(testN);
//        LinkedList<Node> table = new LinkedList<Node>();
//        table.add(testN);
        System.out.println(table[0]);
    }
}