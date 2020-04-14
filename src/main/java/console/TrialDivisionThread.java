package console;

public class TrialDivisionThread extends Thread implements PrimeNumber {
    Integer numberToCheck;

    public TrialDivisionThread(Integer numberToCheck){
        this.numberToCheck = numberToCheck;
    }
    public synchronized void run() {
        isPrimeNumber(numberToCheck);

    }

    @Override
    public void isPrimeNumber(Integer number) {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!Main.divQueue.isEmpty() && !Main.found) {
            try {
                Main.semaphore.acquire();
                Integer div = Main.divQueue.poll();
                if (div != null) {

                    if (number % div == 0) {
                        Main.found = true;
                        Main.isPrime = false;
                        Main.minDenominator = div;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Main.semaphore.release();
        }
        if(!Main.found) {
            Main.isPrime = true;
        }
    }
}
