/*
package console;

public class TrialDivisionThread extends Thread implements IPrimeChecker {
    Long numberToCheck;

    public TrialDivisionThread(Long numberToCheck){
        this.numberToCheck = numberToCheck;
    }
    public synchronized void run() {
        isPrimeNumber(numberToCheck, 0);
    }

    @Override
    public boolean isPrimeNumber(Long number, int iter) {
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
                        Main.minDenominator = div;
                        return false;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Main.semaphore.release();
        }
        if(!Main.found) {
            return true;
        }
    }
}
*/
