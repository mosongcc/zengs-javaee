package zengs.main;

import java.util.concurrent.*;

public class TestThread {

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Future future = executor.submit(new Thread(){
            @Override
            public void run(){
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("-");
                }
            }
        });
        try {
            future.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

}
