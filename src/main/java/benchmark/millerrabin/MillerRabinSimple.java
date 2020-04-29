package benchmark.millerrabin;

import java.math.BigInteger;
import java.util.Random;

public class MillerRabinSimple {

    private long modPow(long a, long b, long c) {
        long res = 1;
        for (int i = 0; i < b; i++) {
            res *= a;
            res %= c;
        }
        return res % c;
    }

    private long mulMod(long a, long b, long mod) {
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();
    }

    public Boolean isPrimeNumber(long numberToCheck, int iterations) {
        long s = numberToCheck - 1;
        while (s % 2 == 0)
            s /= 2;
        Random rand = new Random();
        for (int i = 0; i < iterations; i++) {
            long r = Math.abs(rand.nextLong());
            long a = r % (numberToCheck - 1) + 1, temp = s;
            long mod = modPow(a, temp, numberToCheck);
            while (temp != numberToCheck - 1 && mod != 1 && mod != numberToCheck - 1) {
                mod = mulMod(mod, mod, numberToCheck);
                temp *= 2;
            }
            if (mod != numberToCheck - 1 && temp % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MillerRabinSimple millerRabinSimple = new MillerRabinSimple();
        System.out.println(millerRabinSimple.isPrimeNumber(3571, 100));
    }
}
