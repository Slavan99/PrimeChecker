package console.PrimeChecker.fermat;

import static org.junit.jupiter.api.Assertions.*;

import console.PrimeChecker.fermat.FermatHandler;
import console.PrimeChecker.trialdivision.TrialDivisionHandler;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

class FermatHandlerTest {

    @Test
    void testIsPrimeNumberFermat() throws ExecutionException, InterruptedException {
        FermatHandler fermatHandler = new FermatHandler();
        assertTrue(fermatHandler.isPrimeNumber((long) 17, 100));
        assertTrue(fermatHandler.isPrimeNumber((long) 101, 50));
        assertTrue(fermatHandler.isPrimeNumber((long) 5, 10));
        assertFalse(fermatHandler.isPrimeNumber((long) 561, 5));
    }

}