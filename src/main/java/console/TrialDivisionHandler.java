package console;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TrialDivisionHandler {

    static volatile boolean found = false;
    static volatile long minDenominator = 0;
    static int threadCount = Runtime.getRuntime().availableProcessors();
    public static void handle(Long number) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<Boolean>> futures = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            TrialDivisionThreadCallable threadCallable = new TrialDivisionThreadCallable(number, 3 + 2 * i);
            Future<Boolean> future = executorService.submit(threadCallable);
            futures.add(future);
        }
        boolean result = true;
        for (Future future: futures) {
            result &= (Boolean) future.get();
        }
        if(result)
            System.out.println("Число " + number + " простое");
        else
            System.out.println("Число " + number + " не простое! Его минимальный делитель: " + minDenominator);
        executorService.shutdown();
    }


    static class TrialDivisionThreadCallable implements Callable<Boolean>, IPrimeChecker {
        long numberToCheck;
        long startPos;
        public TrialDivisionThreadCallable(long numberToCheck, long startPos) {
            this.numberToCheck = numberToCheck;
            this.startPos = startPos;
        }

        @Override
        public boolean isPrimeNumber(Long n, int iter) {
            if(!found)
                for(long i = startPos; i <= Math.sqrt(numberToCheck); i+= 2 * threadCount){
                    if(n % i == 0){
                        found = true;
                        minDenominator = i;
                        return false;
                    }
                }
            return true;
        }

        @Override
        public Boolean call() {
            return isPrimeNumber(numberToCheck, 0);
        }
    }
}