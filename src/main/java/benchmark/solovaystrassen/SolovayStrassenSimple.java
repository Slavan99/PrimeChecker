package benchmark.solovaystrassen;

import java.util.Random;

public class SolovayStrassenSimple {
    public long Jacobi(long a, long b) {
        if (b <= 0 || b % 2 == 0)
            return 0;
        long j = 1L;
        if (a < 0) {
            a = -a;
            if (b % 4 == 3)
                j = -j;
        }
        while (a != 0) {
            while (a % 2 == 0) {
                a /= 2;
                if (b % 8 == 3 || b % 8 == 5)
                    j = -j;
            }

            long temp = a;
            a = b;
            b = temp;

            if (a % 4 == 3 && b % 4 == 3)
                j = -j;
            a %= b;
        }
        if (b == 1)
            return j;
        return 0;
    }

    public long modPow(long a, long b, long c) {
        long res = 1;
        for (int i = 0; i < b; i++) {
            res *= a;
            res %= c;
        }
        return res % c;
    }

    public Boolean isPrimeNumber(long numberToCheck, int iterations) {
        Random rand = new Random();
        for (int i = 0; i < iterations; i++) {
            long r = Math.abs(rand.nextLong());
            long a = r % (numberToCheck - 1) + 1;
            long jacobian = (numberToCheck + Jacobi(a, numberToCheck)) % numberToCheck;
            long mod = modPow(a, (numberToCheck - 1) / 2, numberToCheck);
            if (jacobian == 0 || mod != jacobian) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SolovayStrassenSimple solovayStrassenSimple = new SolovayStrassenSimple();
        System.out.println(solovayStrassenSimple.isPrimeNumber(373,50));
    }
}
