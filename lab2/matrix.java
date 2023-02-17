public class matrix {
    private int [][] mat;
    private int size;

    public matrix(int a) {
        mat = new int[a][a];
        size = a;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                this.setMat(i, j, 1);
            }
        }
    }
    public matrix(int a, int value) {
        mat = new int[a][a];
        size = a;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                this.setMat(i, j, value);
            }
        }
    }

    public int getValue(int s, int c) {
        return mat[s][c];
    }

    public void setMat(int s, int c, int value) {
        mat[s][c] = value;
    }

    public matrix sum(matrix a) {
        if (size == a.size) {
            matrix c = new matrix(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    c.setMat(i, j, this.getValue(i,j) + a.getValue(i, j));
                }
            }
            return c;
        }
        else {
            return a;
        }
    }
    public matrix product(matrix a) {

            matrix temp = new matrix(size, 0);
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++)
                        temp.setMat(i, j, this.getValue(i, k) * a.getValue(k, j) + temp.getValue(i, j));
                }
            return temp;


    }
    public String toStr() {
        String c = "matrix{size = " + size + "\nmat value: \n";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                c += " " + getValue(i, j);
            }
            c += "\n";
        }
        return c + "}";

    }
}
