package Matrixes;

import java.util.LinkedList;
import java.util.ListIterator;

public class SparseMatrix implements Matrix {

    int row;
    int col;
    LinkedList<Node> [] table;

    SparseMatrix(int row, int col) {

    }

    @Override
    public Matrix add(Matrix a) throws SumMatrixException {
        return null;
    }

    @Override
    public Matrix product(Matrix a) throws ProductMatrixException {
        return null;
    }

    @Override
    public int getValue(int row, int col) {
        return 0;
    }

    @Override
    public void setValue(int row, int col, int value) {

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
