package Matrixes;

import java.util.LinkedList;
import java.util.ListIterator;

public class SparseMatrix implements Matrix {
    LinkedList<Node> [] table;
    int row;
    int col;

    public SparseMatrix(int row, int col) {
        this.row = row;
        this.col = col;

        table = new LinkedList[row];
        for (int i = 0; i < row; i++)
            table[i] = new LinkedList<Node>();
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getCol() {
        return col;
    }


    public SparseMatrix add(Matrix a) throws SumMatrixException {
        SparseMatrix temp = new SparseMatrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp.setValue(i, j, this.getValue(i, j) + a.getValue(i, j));
            }
        }
        if ((row != a.getRow()) || (col != a.getCol())) {
            throw new MatErrors("Matrix's size are differents");
        }
        return temp;
    }

    @Override
    public SparseMatrix product(Matrix a) throws ProductMatrixException {
        if (col == a.getRow()) {
            SparseMatrix temp_mat = new SparseMatrix(row, a.getCol());
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < a.getCol(); j++) {
                    int temp = 0;
                    for (int k = 0; k < col; k++) {
                        temp += this.getValue(i, k) * a.getValue(k, j);
                    }
                    temp_mat.setValue(i, j, temp);
                }
            }
            return temp_mat;
        } else {
            throw new MatErrors("Differents sizes of matrix");
        }
    }

    @Override
    public int getValue(int row, int col) {
        if ((row >= this.row) || (col >= this.col))
            throw new MatErrors("Unable to execute: out of bound");
        for (Node it : table[row]) {
            if (it.getIndex() == col)
                return it.getValue();
        }
        return 0;
    }

    @Override
    public void setValue(int row, int col, int value) {
        if ((row >= this.row) || (col >= this.col))
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
        boolean flag = true;
        if (a != null) {
            for (int i = 0; i < row; i++)
                for (int j = 0; j < col; j++) {
                    if (getValue(i, j) != a.getValue(i, j)) {
                        flag = false;
                        break;
                    }
                }
            return flag;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder c = new StringBuilder();
        c.append("matrix{rows = ").append(row).append(" columns = ").append(col).append("\nmat value: \n");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                c.append(" ").append(getValue(i, j));
            }
            c.append("\n");
        }
        c.append("}");

        return c.toString();
    }
}
