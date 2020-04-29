package benchmark.fermat;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.ExecutionException;

public class FermatBenchmarkMain {
    public static void main(String[] args) throws RunnerException, ExecutionException, InterruptedException {

        final Options options = new OptionsBuilder()
                .include(FermatBenchmarkTest.class.getSimpleName())
                .warmupIterations(1)
                .measurementIterations(30)
                .threads(Runtime.getRuntime().availableProcessors())
                .forks(1)
                .build();

        new Runner(options).run();

         /*
        FermatHandler fermatHandler = new FermatHandler();
        FermatSimple fermatSimple = new FermatSimple();
        System.out.println("Многопоточный Ферма время работы");
        long time1 = System.currentTimeMillis();
        fermatHandler.isPrimeNumber(1995011,50);
        fermatHandler.isPrimeNumber(11004979, 50);
        fermatHandler.isPrimeNumber(11004893, 50);
        fermatHandler.isPrimeNumber(999999983, 50);
        fermatHandler.isPrimeNumber(999999979, 50);
        fermatHandler.isPrimeNumber(999999983, 50);
        fermatHandler.isPrimeNumber(999999983, 50);
        fermatHandler.isPrimeNumber(999999983, 50);
        fermatHandler.isPrimeNumber(999999983, 50);
        System.out.println(System.currentTimeMillis() - time1);
        System.out.println("Однопоточный Ферма время работы");
        long time2 = System.currentTimeMillis();
        fermatSimple.isPrimeNumber(1995011, 50);
        fermatSimple.isPrimeNumber(11004979, 50);
        fermatSimple.isPrimeNumber(11004893, 50);
        fermatSimple.isPrimeNumber(999999983, 50);
        fermatSimple.isPrimeNumber(999999979, 50);
        fermatSimple.isPrimeNumber(999999983, 50);
        fermatSimple.isPrimeNumber(999999983, 50);
        fermatSimple.isPrimeNumber(999999983, 50);
        fermatSimple.isPrimeNumber(999999983, 50);
        System.out.println(System.currentTimeMillis() - time2);

          */
    }
}
