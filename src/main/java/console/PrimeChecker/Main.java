package console.PrimeChecker;

import console.PrimeChecker.millerrabin.MillerRabinHandler;
import console.PrimeChecker.fermat.FermatHandler;
import console.PrimeChecker.trialdivision.TrialDivisionHandler;
import console.PrimeChecker.solovaystrassen.SolovayStrassenHandler;

import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        System.out.print("Введите число для проверки: ");
        Scanner scanner = new Scanner(System.in);
        try {
            long number = scanner.nextLong();
            System.out.println("Каким алгоритмом проверить число на простоту? 1 - тест Ферма, 2 - перебор делителей" +
                    ", 3 - тест Соловея-Штрассена, 4 - тест Миллера-Рабина");
            String option = scanner.next();
            if ("1".equals(option)) {
                System.out.println("С какой точностью проверить? Чем больше, тем точнее!");
                try {
                    int iter = scanner.nextInt();
                    FermatHandler fermatHandler = new FermatHandler();
                    fermatHandler.handle(number, iter);
                } catch (InputMismatchException e) {
                    System.out.println("Неправильный ввод");
                }
            } else if ("2".equals(option)) {
                TrialDivisionHandler trialDivisionHandler = new TrialDivisionHandler();
                trialDivisionHandler.handle(number);
            } else if ("3".equals(option)) {
                System.out.println("С какой точностью проверить? Чем больше, тем точнее!");
                try {
                    int iter = scanner.nextInt();
                    SolovayStrassenHandler solovayStrassenHandler = new SolovayStrassenHandler();
                    solovayStrassenHandler.handle(number, iter);
                } catch (InputMismatchException e) {
                    System.out.println("Неправильный ввод");
                }
            } else if ("4".equals(option)) {
                System.out.println("С какой точностью проверить? Чем больше, тем точнее!");
                try {
                    int iter = scanner.nextInt();
                    MillerRabinHandler millerRabinHandler = new MillerRabinHandler();
                    millerRabinHandler.handle(number, iter);
                } catch (InputMismatchException e) {
                    System.out.println("Неправильный ввод");
                }
            } else
                System.out.println("Неправильный ввод");
        } catch (InputMismatchException e) {
            System.out.println("Неправильный ввод");
        }
    }
}
