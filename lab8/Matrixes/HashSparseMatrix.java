package Matrixes;
import java.util.HashMap;
import java.util.LinkedList;

public class HashSparseMatrix implements Matrix{
    HashMap<Integer, Integer> [] table;
    int row;
    int col;
    public HashSparseMatrix(int row, int col) {
        this.row = row;
        this.col = col;

        table = new HashMap[row];
        for (int i = 0; i < row; i++)
            table[i] = new HashMap<Integer, Integer>();
    }
    @Override
    public int getRow() {
        return row;
    }
    @Override
    public int getCol() {
        return col;
    }

    @Override
    public HashSparseMatrix add(Matrix a) throws SumMatrixException {
        HashSparseMatrix temp = new HashSparseMatrix(row, col);
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
    public HashSparseMatrix product(Matrix a) throws ProductMatrixException {

        if (col == a.getRow()) {
            HashSparseMatrix temp_mat = new HashSparseMatrix(row, a.getCol());
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
        if (table[row].containsKey(col))
            return table[row].get(col);
        return 0;
    }

    @Override
    public void setValue(int row, int col, int value) {
        if ((row >= this.row) || (col >= this.col))
            throw new MatErrors("Unable to execute: out of bound");
        table[row].put(col, value);
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

