package benchmark.trialdivision;

import console.PrimeChecker.trialdivision.TrialDivisionHandler;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class TrialDivisionBenchmarkTest {
    TrialDivisionSimple trialDivisionSimple;
    TrialDivisionHandler trialDivisionHandler;

    @Setup
    public void setupTrialDivision() {
        trialDivisionSimple = new TrialDivisionSimple();
        trialDivisionHandler = new TrialDivisionHandler();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testTrialDivisionHandler(Blackhole blackhole) throws ExecutionException, InterruptedException {
        blackhole.consume(trialDivisionHandler.isPrimeNumber(1995011, 0));
        blackhole.consume(trialDivisionHandler.isPrimeNumber(11004979, 0));
        blackhole.consume(trialDivisionHandler.isPrimeNumber(11004893, 0));
        blackhole.consume(trialDivisionHandler.isPrimeNumber(999999983, 0));
        blackhole.consume(trialDivisionHandler.isPrimeNumber(999999979, 0));
        blackhole.consume(trialDivisionHandler.isPrimeNumber(999999983, 0));
        blackhole.consume(trialDivisionHandler.isPrimeNumber(999999983, 0));
        blackhole.consume(trialDivisionHandler.isPrimeNumber(999999983, 0));
        blackhole.consume(trialDivisionHandler.isPrimeNumber(999999983, 0));

    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testTrialDivisionSimple(Blackhole blackhole) {
        blackhole.consume(trialDivisionSimple.isPrimeNumber(1995011));
        blackhole.consume(trialDivisionSimple.isPrimeNumber(11004979));
        blackhole.consume(trialDivisionSimple.isPrimeNumber(11004893));
        blackhole.consume(trialDivisionSimple.isPrimeNumber(999999983));
        blackhole.consume(trialDivisionSimple.isPrimeNumber(999999979));
        blackhole.consume(trialDivisionSimple.isPrimeNumber(999999983));
        blackhole.consume(trialDivisionSimple.isPrimeNumber(999999983));
        blackhole.consume(trialDivisionSimple.isPrimeNumber(999999983));
        blackhole.consume(trialDivisionSimple.isPrimeNumber(999999983));
    }
}
