package console;


public class AddToQueueThread extends Thread{
    Integer numberToCheck;

    public AddToQueueThread(Integer numberToCheck){
        this.numberToCheck = numberToCheck;
    }
    public void run() {
        for (int i = 2; i <= Math.sqrt(numberToCheck); i++) {
            Main.divQueue.add(i);
        }
    }
}
