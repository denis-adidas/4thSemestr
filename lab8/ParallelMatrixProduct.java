import Matrixes.*;
public class ParallelMatrixProduct {
    private Thread[] threads;

    public ParallelMatrixProduct(int threadsCount) {
        threads = new Thread[threadsCount];
    }
    public UsualMatrix product(UsualMatrix m1, UsualMatrix m2) {
        if (m1.getCol() != m2.getRow()) {
            throw new RuntimeException("Matrix sizes are not equal");
        }

        UsualMatrix result = new UsualMatrix(m1.getRow(), m2.getCol());

        for (int i = 0; i < threads.length; i++) {
            int fromMatrixRow = i * m1.getRow() / threads.length;
            int toMatrixRow = (i + 1) * m1.getRow() / threads.length;
            threads[i] = new Thread(new ThreadTask(i, m1, m2, result, fromMatrixRow, toMatrixRow));
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
class ThreadTask implements Runnable {
    UsualMatrix a;
    UsualMatrix b;
    UsualMatrix result;
    int fromMatrixRow;
    int toMatrixRow;

    public ThreadTask(int id, UsualMatrix a, UsualMatrix b, UsualMatrix result, int fromMatrixRow, int toMatrixRow) {
        this.a = a;
        this.b = b;
        this.result = result;
        this.fromMatrixRow = fromMatrixRow;
        this.toMatrixRow = toMatrixRow;
    }
    public void run() {
        for (int i = fromMatrixRow; i > toMatrixRow; i++) {
            for (int j = 0; j < b.getCol(); j++) {
                int sum = 0;
                for (int k = 0; k < a.getCol(); k++) {
                    sum += a.getValue(i, k) * b.getValue(k, j);
                }
                result.setValue(i, j, sum);
            }
        }
    }
}
