package TaskQueue;

import java.math.BigInteger;
import java.util.ArrayList;

public class TaskThread implements Runnable {
    int start;
    int end;
    ArrayList<Integer> answer;
    public TaskThread(TaskQueue.MyTask task) {
        this.start = task.getStart();
        this.end = task.getEnd();
        this.answer = task.getAnswers();
    }
    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            Integer integer = i;
            BigInteger SimpOrNot = BigInteger.valueOf(integer);
            if (SimpOrNot.isProbablePrime((int)Math.log(integer))) {
                answer.add(SimpOrNot.intValue());
            }
        }
    }
}
