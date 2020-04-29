package benchmark.fermat;

import console.PrimeChecker.fermat.FermatHandler;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class FermatBenchmarkTest {
    FermatSimple fermatSimple;
    FermatHandler fermatHandler;

    @Setup
    public void setupFermat() {
        fermatHandler = new FermatHandler();
        fermatSimple = new FermatSimple();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testFermatHandler(Blackhole blackhole) throws ExecutionException, InterruptedException {
        blackhole.consume(fermatHandler.isPrimeNumber(1995011, 50));
        blackhole.consume(fermatHandler.isPrimeNumber(11004979, 50));
        blackhole.consume(fermatHandler.isPrimeNumber(11004893, 50));
        blackhole.consume(fermatHandler.isPrimeNumber(999999983, 50));
        blackhole.consume(fermatHandler.isPrimeNumber(999999979, 50));
        blackhole.consume(fermatHandler.isPrimeNumber(999999983, 50));
        blackhole.consume(fermatHandler.isPrimeNumber(999999983, 50));
        blackhole.consume(fermatHandler.isPrimeNumber(999999983, 50));
        blackhole.consume(fermatHandler.isPrimeNumber(999999983, 50));

    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testFermatSimple(Blackhole blackhole) {
        blackhole.consume(fermatSimple.isPrimeNumber(1995011, 50));
        blackhole.consume(fermatSimple.isPrimeNumber(11004979, 50));
        blackhole.consume(fermatSimple.isPrimeNumber(11004893, 50));
        blackhole.consume(fermatSimple.isPrimeNumber(999999983, 50));
        blackhole.consume(fermatSimple.isPrimeNumber(999999979, 50));
        blackhole.consume(fermatSimple.isPrimeNumber(999999983, 50));
        blackhole.consume(fermatSimple.isPrimeNumber(999999983, 50));
        blackhole.consume(fermatSimple.isPrimeNumber(999999983, 50));
        blackhole.consume(fermatSimple.isPrimeNumber(999999983, 50));
    }
}
