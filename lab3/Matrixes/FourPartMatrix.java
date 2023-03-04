package Matrixes;

public class FourPartMatrix extends Matrix {
  int extra_row;
  int extra_col;

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
      throw new MatErrors("Out of bound");
  }
  public void setMat(int r, int c, int value) {
    r = r % extra_row;
    c = c % extra_col;
    if (((r >= 0) && (r <= row)) && ((c >= 0) && (c <= col))) {
      mat[r][c] = value;
    }
    else
      throw new MatErrors("Out of bound");
  }
}
