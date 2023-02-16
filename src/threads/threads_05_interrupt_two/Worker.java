package threads.threads_05_interrupt_two;

import java.util.Random;

public class Worker implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        System.out.println("Рабочий готов");
        do {
            if (!Thread.interrupted()) {
                System.out.println("Worker:  Мне сказали остановиться. А хочу ли я?! Подбросим монетку...");
                int coin = random.nextInt(100);
                if (coin >= 50) {
                    System.out.println("На монетке выпал \"Орел\", по этому продолжу работать. ");
                } else {
                    System.out.println("На монетке выпала \"Решка\". Прекращаю работу.");
                    return;
                }
                System.out.println();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

        } while (true);
    }
}


