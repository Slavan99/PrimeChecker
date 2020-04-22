package console;


public class AddToQueueThread extends Thread{
    Long numberToCheck;

    public AddToQueueThread(Long numberToCheck){
        this.numberToCheck = numberToCheck;
    }
    public void run() {
        for (int i = 2; i <= Math.sqrt(numberToCheck); i++) {
            Main.divQueue.add(i);
        }
    }
}
