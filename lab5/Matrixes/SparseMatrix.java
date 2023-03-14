package Matrixes;

import java.util.LinkedList;
import java.util.ListIterator;

public class SparseMatrix implements Matrix {
    LinkedList<Node> [] table;
    int row;
    int col;

    SparseMatrix(int row, int col) {
        this.row = row;
        this.col = col;

        table = new LinkedList[row];
        for (int i = 0; i < row; i++)
            table[i] = new LinkedList<Node>();
    }

    @Override
    public Matrix add(Matrix a) throws SumMatrixException {
        if ((row != a.row) || (col != a.col)) {
            throw new MatErrors("Matrix's size are differents");
        }
        Matrix temp = new UsualMatrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp.setValue(i, j, this.getValue(i, j) + a.getValue(i, j));
            }
        }
        return temp;
    }

    @Override
    public Matrix product(Matrix a) throws ProductMatrixException {
        return null;
    }

    @Override
    public int getValue(int row, int col) {
        if ((row > this.row) || (col > this.col))
            throw new MatErrors("Unable to execute: out of bound");
        for (Node it : table[row]) {
            if (it.getIndex() == col)
                return it.getValue();
        }
        return 0;
    }

    @Override
    public void setValue(int row, int col, int value) {
        if ((row > this.row) || (col > this.col))
            throw new MatErrors("Unable to execute: out of bound");
        if (getValue(row, col) != 0) {
            for (Node it : table[row]) {
                if (it.getIndex() == col) {
                    it.setValue(value);
                }
            }
        }
        else {
            Node a = new Node(col, value);
            table[row].add(a);
        }
    }

    @Override
    public boolean equal(Matrix a) {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }
}
