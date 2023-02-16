package threads.threads_07_sync_static_not_static;

public class SaySomething_static {

    public static volatile boolean go = false;

    public static synchronized void saySomething(String string) {
        for (int i = 0; i < 5; i++) {
            System.out.println(string + ": counting - " + i);
        }
    }



    static class SayTest implements Runnable {
        private final SaySomething_static demo;
        private final String name;

        public SayTest(String name, SaySomething_static demo) {
            this.name = name;
            this.demo = demo;
        }

        @Override
        public void run() {
            while (!demo.go) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            }
            demo.saySomething(name);
        }
    }

    static class Test {
        public static void main(String[] args) throws InterruptedException {
            SaySomething_static saySomethingDemo1 = new SaySomething_static();
            SaySomething_static saySomethingDemo2 = new SaySomething_static();

            new Thread(new SaySomething_static.SayTest("Thread 1", saySomethingDemo1)).start();
            new Thread(new SaySomething_static.SayTest("Thread 2", saySomethingDemo2)).start();

            Thread.sleep(100);

            SaySomething_static.go = true;
        }
    }
}