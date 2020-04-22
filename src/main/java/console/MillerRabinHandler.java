
package console;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class MillerRabinHandler {
    static volatile boolean found = false;
    static int threadCount = Runtime.getRuntime().availableProcessors();
    public static void handle(Long number, int iter) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<Boolean>> futures = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            MillerRabinCheckerThread millerRabinCheckerThread= new MillerRabinCheckerThread(number, (int) Math.ceil(iter / threadCount));
            Future<Boolean> future = executorService.submit(millerRabinCheckerThread);
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

    static class MillerRabinCheckerThread implements IPrimeChecker, Callable<Boolean> {
        long numberToCheck;
        int iterations;


        public MillerRabinCheckerThread(long numberToCheck, int iterations) {
            this.numberToCheck = numberToCheck;
            this.iterations = iterations;
        }

        private long modPow(long a, long b, long c) {
            long res = 1;
            for (int i = 0; i < b; i++) {
                res *= a;
                res %= c;
            }
            return res % c;
        }

        private long mulMod(long a, long b, long mod) {
            return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();
        }

        @Override
        public boolean isPrimeNumber(Long n, int iter) {
            if(!found) {
                if (n == 0 || n == 1)
                    return false;

                if (n == 2)
                    return true;

                if (n % 2 == 0)
                    return false;

                long s = n - 1;
                while (s % 2 == 0)
                    s /= 2;

                Random rand = new Random();
                for (int i = 0; i < iter; i++) {
                    long r = Math.abs(rand.nextLong());
                    long a = r % (n - 1) + 1, temp = s;
                    long mod = modPow(a, temp, n);
                    while (temp != n - 1 && mod != 1 && mod != n - 1) {
                        mod = mulMod(mod, mod, n);
                        temp *= 2;
                    }
                    if (mod != n - 1 && temp % 2 == 0) {
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