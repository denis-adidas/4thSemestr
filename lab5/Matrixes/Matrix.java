package Matrixes;
public interface Matrix {
    int row = 0;
    int col = 0;
    Matrix add(Matrix a) throws SumMatrixException;
    Matrix product(Matrix a) throws ProductMatrixException;
    int getValue(int row, int col);
    void setValue(int row, int col, int value);
    boolean equal(Matrix a);
    String toString();
}
