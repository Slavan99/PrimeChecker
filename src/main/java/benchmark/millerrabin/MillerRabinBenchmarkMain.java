package benchmark.millerrabin;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.ExecutionException;

public class MillerRabinBenchmarkMain {
    public static void main(String[] args) throws RunnerException, ExecutionException, InterruptedException {

        final Options options = new OptionsBuilder()
                .include(MillerRabinBenchmarkTest.class.getSimpleName())
                .warmupIterations(1)
                .measurementIterations(30)
                .threads(Runtime.getRuntime().availableProcessors())
                .forks(1)
                .build();

        new Runner(options).run();

         /*
        MillerRabinHandler MillerRabinHandler = new MillerRabinHandler();
        MillerRabinSimple MillerRabinSimple = new MillerRabinSimple();
        System.out.println("Многопоточный Ферма время работы");
        long time1 = System.currentTimeMillis();
        MillerRabinHandler.isPrimeNumber(1995011,50);
        MillerRabinHandler.isPrimeNumber(11004979, 50);
        MillerRabinHandler.isPrimeNumber(11004893, 50);
        MillerRabinHandler.isPrimeNumber(999999983, 50);
        MillerRabinHandler.isPrimeNumber(999999979, 50);
        MillerRabinHandler.isPrimeNumber(999999983, 50);
        MillerRabinHandler.isPrimeNumber(999999983, 50);
        MillerRabinHandler.isPrimeNumber(999999983, 50);
        MillerRabinHandler.isPrimeNumber(999999983, 50);
        System.out.println(System.currentTimeMillis() - time1);
        System.out.println("Однопоточный Ферма время работы");
        long time2 = System.currentTimeMillis();
        MillerRabinSimple.isPrimeNumber(1995011, 50);
        MillerRabinSimple.isPrimeNumber(11004979, 50);
        MillerRabinSimple.isPrimeNumber(11004893, 50);
        MillerRabinSimple.isPrimeNumber(999999983, 50);
        MillerRabinSimple.isPrimeNumber(999999979, 50);
        MillerRabinSimple.isPrimeNumber(999999983, 50);
        MillerRabinSimple.isPrimeNumber(999999983, 50);
        MillerRabinSimple.isPrimeNumber(999999983, 50);
        MillerRabinSimple.isPrimeNumber(999999983, 50);
        System.out.println(System.currentTimeMillis() - time2);

          */
    }
}
