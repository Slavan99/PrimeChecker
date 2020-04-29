package benchmark.millerrabin;

import console.PrimeChecker.millerrabin.MillerRabinHandler;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class MillerRabinBenchmarkTest {
    MillerRabinSimple MillerRabinSimple;
    MillerRabinHandler MillerRabinHandler;

    @Setup
    public void setupMillerRabin() {
        MillerRabinHandler = new MillerRabinHandler();
        MillerRabinSimple = new MillerRabinSimple();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testMillerRabinHandler(Blackhole blackhole) throws ExecutionException, InterruptedException {
        blackhole.consume(MillerRabinHandler.isPrimeNumber(1995011, 50));
        blackhole.consume(MillerRabinHandler.isPrimeNumber(11004979, 50));
        blackhole.consume(MillerRabinHandler.isPrimeNumber(11004893, 50));
        blackhole.consume(MillerRabinHandler.isPrimeNumber(999999983, 50));
        blackhole.consume(MillerRabinHandler.isPrimeNumber(999999979, 50));
        blackhole.consume(MillerRabinHandler.isPrimeNumber(999999983, 50));
        blackhole.consume(MillerRabinHandler.isPrimeNumber(999999983, 50));
        blackhole.consume(MillerRabinHandler.isPrimeNumber(999999983, 50));
        blackhole.consume(MillerRabinHandler.isPrimeNumber(999999983, 50));

    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testMillerRabinSimple(Blackhole blackhole) {
        blackhole.consume(MillerRabinSimple.isPrimeNumber(1995011, 50));
        blackhole.consume(MillerRabinSimple.isPrimeNumber(11004979, 50));
        blackhole.consume(MillerRabinSimple.isPrimeNumber(11004893, 50));
        blackhole.consume(MillerRabinSimple.isPrimeNumber(999999983, 50));
        blackhole.consume(MillerRabinSimple.isPrimeNumber(999999979, 50));
        blackhole.consume(MillerRabinSimple.isPrimeNumber(999999983, 50));
        blackhole.consume(MillerRabinSimple.isPrimeNumber(999999983, 50));
        blackhole.consume(MillerRabinSimple.isPrimeNumber(999999983, 50));
        blackhole.consume(MillerRabinSimple.isPrimeNumber(999999983, 50));
    }
}
