package console.PrimeChecker.trialdivision;

import console.PrimeChecker.IPrimeChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TrialDivisionHandler implements IPrimeChecker {

    private static volatile boolean found = false;
    private static int threadCount = Runtime.getRuntime().availableProcessors();

    public void handle(Long number) throws ExecutionException, InterruptedException {
        if (number < 3) {
            System.out.println("Число должно быть не меньше 3!");
            System.exit(0);
        }
        boolean result = isPrimeNumber(number, 0);
        if (result)
            System.out.println("Число " + number + " простое");
        else
            System.out.println("Число " + number + " составное");
    }

    @Override
    public boolean isPrimeNumber(long number, int iter) throws ExecutionException, InterruptedException {
        if (number % 2 == 0) {
            return false;
        }
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<Boolean>> futures = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            TrialDivisionThreadCallable threadCallable = new TrialDivisionThreadCallable(number, 3 + 2 * i);
            Future<Boolean> future = executorService.submit(threadCallable);
            futures.add(future);
        }
        boolean result = true;
        for (Future future : futures) {
            result &= (Boolean) future.get();
        }
        executorService.shutdown();
        return result;
    }


    static class TrialDivisionThreadCallable implements Callable<Boolean> {
        long numberToCheck;
        long startPos;

        public TrialDivisionThreadCallable(long numberToCheck, long startPos) {
            this.numberToCheck = numberToCheck;
            this.startPos = startPos;
        }


        @Override
        public Boolean call() {
            double sqrt = Math.sqrt(numberToCheck);
            for (long i = startPos; i <= sqrt; i += 2 * threadCount) {
                if (!found) {
                    if (numberToCheck % i == 0) {
                        found = true;
                        return false;
                    }
                }
            }
            return true;
        }
    }
}