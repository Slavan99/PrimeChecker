
package console;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class SolovayStrassenHandler {
    static volatile boolean found = false;
    static int threadCount = Runtime.getRuntime().availableProcessors();
    public static void handle(Long number, int iter) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<Boolean>> futures = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            SolovayStrassenCheckerThread solovayStrassenCheckerThread = new SolovayStrassenCheckerThread(number, (int) Math.ceil(iter / threadCount));
            Future<Boolean> future = executorService.submit(solovayStrassenCheckerThread);
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

    static class SolovayStrassenCheckerThread implements IPrimeChecker, Callable<Boolean> {
        long numberToCheck;
        int iterations;

        public SolovayStrassenCheckerThread(long numberToCheck, int iterations) {
            this.numberToCheck = numberToCheck;
            this.iterations = iterations;
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

                Random rand = new Random();
                for (int i = 0; i < iter; i++) {
                    long r = Math.abs(rand.nextLong());
                    long a = r % (n - 1) + 1;
                    long jacobian = (n + Jacobi(a, n)) % n;
                    long mod = modPow(a, (n - 1) / 2, n);
                    if (jacobian == 0 || mod != jacobian) {
                        found = true;
                        return false;
                    }
                }
            }
            return true;
        }

        public long Jacobi(long a, long b) {
            if (b <= 0 || b % 2 == 0)
                return 0;
            long j = 1L;
            if (a < 0) {
                a = -a;
                if (b % 4 == 3)
                    j = -j;
            }
            while (a != 0) {
                while (a % 2 == 0) {
                    a /= 2;
                    if (b % 8 == 3 || b % 8 == 5)
                        j = -j;
                }

                long temp = a;
                a = b;
                b = temp;

                if (a % 4 == 3 && b % 4 == 3)
                    j = -j;
                a %= b;
            }
            if (b == 1)
                return j;
            return 0;
        }


        public long modPow(long a, long b, long c) {
            long res = 1;
            for (int i = 0; i < b; i++) {
                res *= a;
                res %= c;
            }
            return res % c;
        }

        @Override
        public Boolean call() {
            return isPrimeNumber(numberToCheck, iterations);
        }
    }

}