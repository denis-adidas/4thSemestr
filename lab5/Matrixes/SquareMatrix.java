package Matrixes;
public class SquareMatrix extends UsualMatrix {
    private int size;
    public SquareMatrix(int size) {
        super(size, size);
        this.size = size;
        for (int i = 0; i < size; i++)
            this.setValue(i, i, 1);
    }

    public SquareMatrix sum(SquareMatrix a) {
        if (size == a.size) {
            SquareMatrix c = new SquareMatrix(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    c.setValue(i, j, this.getValue(i,j) + a.getValue(i, j));
                }
            }
            return c;
        }
        else {
            throw new MatErrors("Matrix's size are differents");
        }
    }
}

