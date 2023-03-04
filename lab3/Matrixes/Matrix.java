package Matrixes;
public class Matrix {
    protected int row;
    protected int col;
    protected int[][] mat;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        mat = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = 0;
            }
        }
    }
    public Matrix(int row, int col, int val) {
        this.row = row;
        this.col = col;
        mat = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = val;
            }
        }
    }

    public int getValue(int r, int c) {
        if (((r >= 0) && (r <= row)) && ((c >= 0) && (c <= col)))
            return mat[r][c];
        else
            throw new MatErrors("Out of bound");
    }

    public void setMat(int r, int c, int value) {
        if (((r >= 0) && (r <= row)) && ((c >= 0) && (c <= col)))
            mat[r][c] = value;
        else
            throw new MatErrors("Out of bound");
    }

    public Matrix sum(Matrix a) {

        if ((row != a.row) && (col != a.col)) {
            throw new MatErrors("Matrix's size are differents");
        }
        Matrix temp = new Matrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp.setMat(i, j, this.getValue(i, j) + a.getValue(i, j));
            }
        }
        return temp;
    }

    public Matrix product(Matrix a) {

        if (col == a.row) {
            Matrix temp_mat = new Matrix(row, a.col);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < a.col; j++) {
                    int temp = 0;
                    for (int k = 0; k < col; k++) {
                        temp += this.getValue(i, k) * a.getValue(k, j);
                    }
                    temp_mat.setMat(i, j, temp);
                }
            }
            return temp_mat;
        } else {
            throw new MatErrors("Differents sizes of matrix");
        }
    }
    public boolean equals(Matrix a) {
        boolean flag = true;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if(getValue(i, j) != a.getValue(i, j)){
                    flag = false;
                    break;
                }
            }
        return flag;
    }

    public final String toString() {
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