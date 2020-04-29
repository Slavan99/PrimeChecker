package benchmark.fermat;

public class FermatSimple {
    private long binaryPower(long a, long n) {
        a %= n;
        long res = 1;
        long nMinusOne = n - 1;
        while (nMinusOne > 0) {
            if (nMinusOne % 2 == 1)
                res = res * a % n;
            a = a * a % n;
            nMinusOne >>= 1;
        }
        return res;
    }

    public Boolean isPrimeNumber(long numberToCheck, int iterations) {
        for (int i = 0; i < iterations; i++) {
            int a = (int) (Math.random() * (numberToCheck - 3)) + 2;
            if (binaryPower(a, numberToCheck) != 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FermatSimple fermatSimple = new FermatSimple();
        System.out.println(fermatSimple.isPrimeNumber(3571, 100));
    }
}
