package Matrixes;

public class FourPartMatrix extends Matrix {
public FourPartMatrix(Matrix a) {
  super(a.row, a.col);
  this.row = a.row * 2;
  this.col = a.col * 2;

  mat = new int[a.row * 2][a.col * 2];

  for (int i = 0; i < a.row; i++)
    for (int j = 0; j < a.col; j++) {
      mat[i][j] =  a.getValue(i,j);
    }
  for (int i = 0; i < a.row; i++)
    for (int j = 0; j < a.col; j++) {
      mat[i][j + a.col] =  a.getValue(i,j);
    }
  for (int i = 0; i < a.row; i++)
    for (int j = 0; j < a.col; j++) {
      mat[a.row + i][j] =  a.getValue(i,j);
    }
  for (int i = 0; i < a.row; i++)
    for (int j = 0; j < a.col; j++) {
      mat[a.row + i][a.col + j] =  a.getValue(i,j);
    }
}
}
