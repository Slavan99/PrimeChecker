package benchmark.solovaystrassen;


import console.PrimeChecker.solovaystrassen.SolovayStrassenHandler;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class SolovayStrassenBenchmarkTest {
    SolovayStrassenSimple solovayStrassenSimple;
    SolovayStrassenHandler solovayStrassenHandler;

    @Setup
    public void setupSolovayStrassen() {
        solovayStrassenHandler = new SolovayStrassenHandler();
        solovayStrassenSimple = new SolovayStrassenSimple();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testSolovayStrassenHandler(Blackhole blackhole) throws ExecutionException, InterruptedException {
        blackhole.consume(solovayStrassenHandler.isPrimeNumber(1995011, 50));
        blackhole.consume(solovayStrassenHandler.isPrimeNumber(11004979, 50));
        blackhole.consume(solovayStrassenHandler.isPrimeNumber(11004893, 50));
        blackhole.consume(solovayStrassenHandler.isPrimeNumber(999999983, 50));
        blackhole.consume(solovayStrassenHandler.isPrimeNumber(999999979, 50));
        blackhole.consume(solovayStrassenHandler.isPrimeNumber(999999983, 50));
        blackhole.consume(solovayStrassenHandler.isPrimeNumber(999999983, 50));
        blackhole.consume(solovayStrassenHandler.isPrimeNumber(999999983, 50));
        blackhole.consume(solovayStrassenHandler.isPrimeNumber(999999983, 50));

    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testSolovayStrassenSimple(Blackhole blackhole) {
        blackhole.consume(solovayStrassenSimple.isPrimeNumber(1995011, 50));
        blackhole.consume(solovayStrassenSimple.isPrimeNumber(11004979, 50));
        blackhole.consume(solovayStrassenSimple.isPrimeNumber(11004893, 50));
        blackhole.consume(solovayStrassenSimple.isPrimeNumber(999999983, 50));
        blackhole.consume(solovayStrassenSimple.isPrimeNumber(999999979, 50));
        blackhole.consume(solovayStrassenSimple.isPrimeNumber(999999983, 50));
        blackhole.consume(solovayStrassenSimple.isPrimeNumber(999999983, 50));
        blackhole.consume(solovayStrassenSimple.isPrimeNumber(999999983, 50));
        blackhole.consume(solovayStrassenSimple.isPrimeNumber(999999983, 50));
    }
}
