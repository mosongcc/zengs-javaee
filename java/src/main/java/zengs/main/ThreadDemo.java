package zengs.main;


import java.util.concurrent.*;

/**
 * 线程超时
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Thread td = null;
        FutureTask<String> ft=null;
        try {
            ft = new FutureTask<String>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    /*for (int i = 0; i < 10 ; i++) {
                        //Thread.sleep(3000);
                        System.out.print("-");
                    }*/
                    int i = 0;
                    while (i<1){
                        System.out.print("-");
                    }
                    return "success";
                }
            });
            td = new Thread(ft);
            td.start();

            String s = ft.get(3, TimeUnit.SECONDS);

            System.out.println("执行结果："+s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
           ft.cancel(true);

        }

    }

}
