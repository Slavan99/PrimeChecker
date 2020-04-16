package console;

import java.util.Random;

public class SolovayStrassenChecker implements PrimeNumber {
    @Override
    public void isPrimeNumber(Integer n) {
        Main.isPrime = isPrime(n);
    }

    public long Jacobi(long a, long b)
    {
        if (b <= 0 || b % 2 == 0)
            return 0;
        long j = 1L;
        if (a < 0)
        {
            a = -a;
            if (b % 4 == 3)
                j = -j;
        }
        while (a != 0)
        {
            while (a % 2 == 0)
            {
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
    public boolean isPrime(long n)
    {
        if (n == 0 || n == 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;

        int iteration = 100;
        Random rand = new Random();
        for (int i = 0; i < iteration; i++)
        {
            long r = Math.abs(rand.nextLong());
            long a = r % (n - 1) + 1;
            long jacobian = (n + Jacobi(a, n)) % n;
            long mod = modPow(a, (n - 1)/2, n);
            if(jacobian == 0 || mod != jacobian)
                return false;
        }
        return true;
    }

    public long modPow(long a, long b, long c)
    {
        long res = 1;
        for (int i = 0; i < b; i++)
        {
            res *= a;
            res %= c;
        }
        return res % c;
    }
}