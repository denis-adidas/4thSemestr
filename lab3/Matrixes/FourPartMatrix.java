package Matrixes;

public class FourPartMatrix extends Matrix {
  int extra_row;
  int extra_col;
  public FourPartMatrix(int row, int col) {
        super(row / 2, col / 2);
        if ((row  % 2 != 0) || (col % 2 != 0))
          throw new MatErrors("Wrong size. Rows and columns should be even");

    this.extra_row = row / 2;
    this.extra_col = col / 2;

    this.row = row;
    this.col = col;
  }
public FourPartMatrix(Matrix a) {

  super(a.row, a.col);

  this.extra_row = a.row;
  this.extra_col = a.col;

  this.row = a.row * 2;
  this.col = a.col * 2;

  this.mat = a.mat.clone();
}
  public int getValue(int r, int c) {
    r = r % extra_row;
    c = c % extra_col;
    if (((r >= 0) && (r <= row)) && ((c >= 0) && (c <= col)))
      return mat[r][c];
    else
      throw new MatErrors("Unable to execute: out of bound");
  }
  public void setMat(int r, int c, int value) {
    r = r % extra_row;
    c = c % extra_col;
    if (((r >= 0) && (r <= row)) && ((c >= 0) && (c <= col))) {
      mat[r][c] = value;
    }
    else
      throw new MatErrors("Unable to execute: out of bound");
  }
  @Override
  public FourPartMatrix sum(Matrix a) {

    if ((row != a.row) || (col != a.col)) {
      throw new SumMatrixException("Unable to execute: matrix's size are differents");
    }
    FourPartMatrix temp = new FourPartMatrix(row, col);
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        temp.setMat(i, j, this.getValue(i, j) + a.getValue(i, j));
      }
    }
    return temp;
  }
  @Override
  public FourPartMatrix product(Matrix a) {

    if (col == a.row) {
      FourPartMatrix temp_mat = new FourPartMatrix(row, a.col);
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
      throw new ProductMatrixException("Unable to execute: differents sizes of matrix");
    }
  }
}
