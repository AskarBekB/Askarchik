

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EX_13_1 {
    private static Integer sum = 0;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        int i = 0;
        while (i < 1000) {
            executor.execute(new AddOne());
            i++;
        }

        executor.shutdown();

        while (true) {
            if (executor.isTerminated()) break;
        }

        System.out.println("sum = " + sum);
    }

    private static class AddOne implements Runnable {
        public void run() {
            add(1);
        }
    }
    public synchronized static void add(int a){
        sum+=a;
    }
}