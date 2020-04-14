package console;

import java.util.Queue;

public class WorkerThread extends Thread {
    Integer numberToCheck;


    public WorkerThread(Integer numberToCheck){
        this.numberToCheck = numberToCheck;
    }
    public void run() {
        try {
            sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!Main.divQueue.isEmpty() && !Main.found) {
            try {
                Main.semaphore.acquire();
                Integer div = Main.divQueue.poll();
                if (div != null) {
                    System.out.println(getName() + " взял число " + div);
                    if (numberToCheck % div == 0) {
                        System.out.println("Число не простое! Его делитель : " + div);
                        Main.found = true;
                    }
                }
            } catch (InterruptedException e) {
                        e.printStackTrace();
            }
            Main.semaphore.release();
        }
        if(!Main.found) {
            System.out.println("Число простое!");
            Main.found = true;
        }

    }
}
