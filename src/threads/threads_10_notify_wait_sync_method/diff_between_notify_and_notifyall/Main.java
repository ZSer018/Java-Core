package threads.threads_10_notify_wait_sync_method.diff_between_notify_and_notifyall;

public class Main {

    private final static Printer printer = new Printer();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new PrintCharThread(printer, 'A', 'B')).start();
        new Thread(new PrintCharThread(printer, 'B', 'C')).start();
        new Thread(new PrintCharThread(printer, 'C', 'A')).start();
    }
}
