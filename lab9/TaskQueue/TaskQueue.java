package TaskQueue;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class TaskQueue {
    public class MyTask {
        int start;
        int end;
        ArrayList<Integer> answers;

        public MyTask(int start, int end) {
            this.start = start;
            this.end = end;
            this.answers = new ArrayList<>();
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public ArrayList<Integer> getAnswers() {
            return answers;
        }
    }
    private LinkedList<MyTask> queue;
    private int size;
    private int count;

    public TaskQueue() {
        this.queue = new LinkedList<MyTask>();
        size = 0;
        count = 0;
    }

    public synchronized void push(int s, int end) {
        MyTask task = new MyTask(s, end);
        queue.add(task);
        size++;
//        notify();
    }

    public synchronized MyTask pop() throws InterruptedException {
//        if (size == 0)
//            wait();
        if (count <= size) {
            MyTask task = queue.get(count);
            count++;
            return task;
        }
        else {
            throw new  InterruptedException();
        }
    }
    public void show() {
        for (MyTask it : queue) {
            System.out.println((it.getAnswers().toString()));
        }
    }
    public int getSize() {
        return size;
    }
    public MyTask getTask() {
        return queue.getFirst();
    }
}

