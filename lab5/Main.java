import Matrixes.*;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        SparseMatrix d = new SparseMatrix(1000, 1000);
        SparseMatrix c = new SparseMatrix(1000, 1000);
        HashSparseMatrix a = new HashSparseMatrix(1000, 1000);
        HashSparseMatrix b = new HashSparseMatrix(1000, 1000);

        for (int j = 0; j < 1000; j++) {
            int row = (int) (Math.random() * (1000-1));
            int column = (int) (Math.random() *  (1000-1));
            int value = (int)(Math.random() * (1000));
            a.setValue(row, column, value);
            b.setValue(row,column,value);
            c.setValue(row, column, value);
            d.setValue(row, column, value);
        }

//        long time_spare = 0;
//        d = d.product(c);
//        time_spare = System.currentTimeMillis();
//        System.out.println("Time list: ");
//        System.out.println(time_spare);
//
//        long time_hash_spare = 0;
//        a = a.product(b);
//        time_hash_spare = System.currentTimeMillis();
//        System.out.println("Time hash: ");
//        System.out.println(time_hash_spare);
//
//        System.out.println("List > hash: " + (time_spare > time_hash_spare));

        a = a.product(b);
        d = d.product(c);

        System.out.println(a.equal(d));
//
//        System.out.println(b.toString());
    }
}