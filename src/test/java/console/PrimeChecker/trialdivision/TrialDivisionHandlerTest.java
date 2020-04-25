package console.PrimeChecker.trialdivision;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class TrialDivisionHandlerTest {

    @Test
    void testIsPrimeNumberTrialDivision() throws ExecutionException, InterruptedException {
        TrialDivisionHandler trialDivisionHandler = new TrialDivisionHandler();
        assertTrue(trialDivisionHandler.isPrimeNumber((long) 101, 0));
        assertTrue(trialDivisionHandler.isPrimeNumber((long) 10501, 0));
    }

}