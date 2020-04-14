package console;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static Queue<Integer> divQueue = new PriorityQueue<>();
    public static Semaphore semaphore = new Semaphore(1, true);
    public static volatile boolean found = false;
    public static volatile boolean isPrime = false;
    public static volatile int minDenominator = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.print("Введите число для проверки: ");
        Scanner scanner = new Scanner(System.in);
        Integer number = scanner.nextInt();
        if(number < 3){
            System.out.println("Число должно быть не меньше 3!");
            System.exit(0);
        }
        AddToQueueThread addToQueueThread = new AddToQueueThread(number);
        TrialDivisionThread trialDivisionThread1 = new TrialDivisionThread(number);
        trialDivisionThread1.setName("Рабочий поток 1");
        TrialDivisionThread trialDivisionThread2 = new TrialDivisionThread(number);
        trialDivisionThread2.setName("Рабочий поток 2");
        addToQueueThread.start();
        trialDivisionThread1.start();
        trialDivisionThread2.start();
        trialDivisionThread1.join();
        trialDivisionThread2.join();
        if(isPrime)
            System.out.println("Число простое");
        else
            System.out.println("Число не простое! Его минимальный делитель: " + minDenominator);
    }
}
