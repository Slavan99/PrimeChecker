package console;

import java.util.concurrent.Callable;

public class TrialDivisionThreadCallable implements Callable<String>, IPrimeChecker {
    @Override
    public void isPrimeNumber(Long n, int iter) {

    }

    @Override
    public String call() throws Exception {
        return "Привет";
    }
}
