package console.PrimeChecker.solovaystrassen;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class SolovayStrassenHandlerTest {

    @Test
    void testIsPrimeNumberSolovayStrassen() throws ExecutionException, InterruptedException {
        SolovayStrassenHandler solovayStrassenHandler = new SolovayStrassenHandler();
        assertTrue(solovayStrassenHandler.isPrimeNumber(17, 5));
        assertFalse(solovayStrassenHandler.isPrimeNumber(901, 50));
        assertFalse(solovayStrassenHandler.isPrimeNumber(660,100));
    }
}