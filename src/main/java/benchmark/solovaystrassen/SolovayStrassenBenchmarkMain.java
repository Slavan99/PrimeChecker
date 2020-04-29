package benchmark.solovaystrassen;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class SolovayStrassenBenchmarkMain {
    public static void main(String[] args) throws RunnerException {
        final Options options = new OptionsBuilder()
                .include(SolovayStrassenBenchmarkTest.class.getSimpleName())
                .warmupIterations(1)
                .measurementIterations(30)
                .threads(Runtime.getRuntime().availableProcessors())
                .forks(1)
                .build();

        new Runner(options).run();
    }
}
