package console.PrimeChecker.millerrabin;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class MillerRabinHandlerTest {

    @Test
    void testIsPrimeNumberMillerRabin() throws ExecutionException, InterruptedException {
        MillerRabinHandler millerRabinHandler = new MillerRabinHandler();
        assertFalse(millerRabinHandler.isPrimeNumber((long) 561,100));
        assertTrue(millerRabinHandler.isPrimeNumber((long) 59, 5));
    }
}