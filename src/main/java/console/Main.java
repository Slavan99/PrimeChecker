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
        System.out.println("Каким алгоритмом проверить число на простоту? 1 - тест Ферма, 2 - перебор делителей" +
                ", 3 - тест Соловея-Штрассена, 4 - тест Миллера-Рабина");
        String option = scanner.next();
        if("1".equals(option)) {
            FermatChecker fermatChecker = new FermatChecker();
            fermatChecker.isPrimeNumber(number);
            if(!isPrime)
                System.out.println("Число составное");
            else
                System.out.println("Число вероятно простое");
        }
        else if("2".equals(option)) {
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
            if (isPrime)
                System.out.println("Число простое");
            else
                System.out.println("Число не простое! Его минимальный делитель: " + minDenominator);
        }
        else if("3".equals(option)){
            SolovayStrassenChecker solovayStrassenChecker = new SolovayStrassenChecker();
            solovayStrassenChecker.isPrimeNumber(number);
            if(!isPrime)
                System.out.println("Число составное");
            else
                System.out.println("Число вероятно простое");
        }
        else if("4".equals(option)){
            MillerRabinChecker millerRabinChecker = new MillerRabinChecker();
            millerRabinChecker.isPrimeNumber(number);
            if(!isPrime)
                System.out.println("Число составное");
            else
                System.out.println("Число вероятно простое");
        }
        else
            System.out.println("Неправильный ввод");
    }
}
