package console;

import java.util.*;

public class Main {

    public static Queue<Integer> divQueue = new PriorityQueue<>();


    public static void main(String[] args) throws Exception {
        System.out.print("Введите число для проверки: ");
        Scanner scanner = new Scanner(System.in);
        try {
            Long number = scanner.nextLong();
            if(number < 3){
                System.out.println("Число должно быть не меньше 3!");
                System.exit(0);
            }
            if(number % 2 == 0)
                System.out.println("Число " + number + " составное");
            else
            {
                System.out.println("Каким алгоритмом проверить число на простоту? 1 - тест Ферма, 2 - перебор делителей" +
                        ", 3 - тест Соловея-Штрассена, 4 - тест Миллера-Рабина");
                String option = scanner.next();
                if ("1".equals(option)) {
                    System.out.println("С какой точностью проверить? Чем больше, тем точнее!");
                    try {
                        int iter = scanner.nextInt();
                        FermatHandler.handle(number, iter);
                    }
                    catch (InputMismatchException e){
                        System.out.println("Неправильный ввод");
                    }
                } else if ("2".equals(option)) {
                    TrialDivisionHandler.handle(number);
                } else if ("3".equals(option)) {
                    System.out.println("С какой точностью проверить? Чем больше, тем точнее!");
                    try {
                        int iter = scanner.nextInt();
                        SolovayStrassenHandler.handle(number, iter);
                    }
                    catch (InputMismatchException e){
                        System.out.println("Неправильный ввод");
                    }
                } else if ("4".equals(option)) {
                    System.out.println("С какой точностью проверить? Чем больше, тем точнее!");
                    try {
                        int iter = scanner.nextInt();
                        MillerRabinHandler.handle(number, iter);
                    }
                    catch (InputMismatchException e){
                        System.out.println("Неправильный ввод");
                    }
                } else
                    System.out.println("Неправильный ввод");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Неправильный ввод");
        }
    }
}
