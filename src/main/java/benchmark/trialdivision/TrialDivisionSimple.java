package benchmark.trialdivision;

public class TrialDivisionSimple {

    public Boolean isPrimeNumber(long numberToCheck) {
        double sqrt = Math.sqrt(numberToCheck);
        for (long i = 2; i <= sqrt; i++) {
            if (numberToCheck % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TrialDivisionSimple trialDivisionSimple = new TrialDivisionSimple();
        System.out.println(trialDivisionSimple.isPrimeNumber(59));
    }
}
