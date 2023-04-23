package TaskQueue;
public class ThreadUtils {
    private Thread[] threads;

    public ThreadUtils(TaskQueue task) throws InterruptedException {
        threads = new Thread[5];
        int i = 0;
        while (i < task.getSize()) {
            threads[i] = new Thread(new TaskThread(task.pop()));
            threads[i].start();
            i++;
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) throws InterruptedException {
        TaskQueue queue = new TaskQueue();
        queue.push(2, 25);
        queue.push(25, 50);
        queue.push(50, 75);
        queue.push(75, 100);
        queue.push(100, 125);
        ThreadUtils solve = new ThreadUtils(queue);
        queue.show();

//        System.out.println(queue.getTask().getAnswers().toString());

    }
}
