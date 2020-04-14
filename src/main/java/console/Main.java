package console;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

public class Main {

    public static Queue<Integer> divQueue = new PriorityQueue<>();
    public static Semaphore semaphore = new Semaphore(1, true);
    public static volatile boolean found = false;

    public static void main(String[] args) {
        Integer number = 49;
        MyThread myThread = new MyThread(number);
        WorkerThread workerThread1 = new WorkerThread(number);
        workerThread1.setName("Рабочий поток 1");
        WorkerThread workerThread2 = new WorkerThread(number);
        workerThread2.setName("Рабочий поток 2");
        myThread.start();
        workerThread1.start();
        workerThread2.start();
        System.out.println(Main.divQueue);
    }
}
