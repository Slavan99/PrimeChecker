package console;

public class FermatChecker implements PrimeNumber{
    private static long binaryPower(long a, long n){
        a %= n;
        long res = 1;
        long nMinusOne = n - 1;
        while(nMinusOne > 0){
            if(nMinusOne % 2 == 1)
                res = res * a % n;
            a = a * a % n;
            nMinusOne >>= 1;
        }
        return res;
    }

    private static boolean probablyPrimeFermat(int n) {
        if (n < 4)
            return n == 2 || n == 3;

        for (int i = 0; i < 100; i++) {
            int a = (int) (Math.random() * (n - 3)) + 2;
            if (binaryPower(a, n) != 1)
                return false;
        }
        return true;
    }

    @Override
    public void isPrimeNumber(Integer n) {
        Main.isPrime = probablyPrimeFermat(n);
    }
}
