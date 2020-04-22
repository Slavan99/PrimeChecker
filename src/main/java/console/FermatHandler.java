package console;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class FermatHandler {
    static volatile boolean found = false;
    static int threadCount = Runtime.getRuntime().availableProcessors();
    public static void handle(Long number, int iter) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<Boolean>> futures = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            FermatCheckerThread fermatCheckerThread = new FermatCheckerThread(number, (int) Math.ceil(iter / threadCount));
            Future<Boolean> future = executorService.submit(fermatCheckerThread);
            futures.add(future);
        }
        boolean result = true;
        for (Future future: futures) {
            result &= (Boolean) future.get();
        }
        if(result)
            System.out.println("Число " + number + " вероятно простое");
        else
            System.out.println("Число " + number + " составное");
        executorService.shutdown();

    }

    static class FermatCheckerThread implements IPrimeChecker, Callable<Boolean> {
        long numberToCheck;
        int iterations;

        public FermatCheckerThread(long numberToCheck, int iterations) {
            this.numberToCheck = numberToCheck;
            this.iterations = iterations;
        }

        private long binaryPower(long a, long n) {
            a %= n;
            long res = 1;
            long nMinusOne = n - 1;
            while (nMinusOne > 0) {
                if (nMinusOne % 2 == 1)
                    res = res * a % n;
                a = a * a % n;
                nMinusOne >>= 1;
            }
            return res;
        }

        @Override
        public boolean isPrimeNumber(Long n, int iter) {
            if(!found) {
                if (numberToCheck < 4)
                    return n == 2 || n == 3;

                for (int i = 0; i < iter; i++) {
                    int a = (int) (Math.random() * (n - 3)) + 2;
                    if (binaryPower(a, n) != 1) {
                        found = true;
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public Boolean call() {
            return isPrimeNumber(numberToCheck, iterations);
        }
    }

}