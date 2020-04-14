package console;


public class MyThread extends Thread{
    Integer numberToCheck;

    public MyThread(Integer numberToCheck){
        this.numberToCheck = numberToCheck;
    }
    public void run() {
        for (int i = 2; i <= Math.sqrt(numberToCheck); i++) {
            Main.divQueue.add(i);
            System.out.println("В очередь добавлено число " + i);
        }
    }
}
