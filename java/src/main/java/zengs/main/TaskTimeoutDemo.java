package zengs.main;

import java.util.concurrent.*;

/**
 * 启动一个任务，然后等待任务的计算结果，如果等待时间超出预设定的超时时间，则中止任务。
 *
 */
public class TaskTimeoutDemo {

    public static void main(String[] args) {
        System.out.println("Start ...");

        ExecutorService exec = Executors.newCachedThreadPool();

        //testTask(exec, 15); // 任务成功结束后等待计算结果，不需要等到15秒
        testTask(exec, 2); // 只等待5秒，任务还没结束，所以将任务中止

        exec.shutdown();
        System.out.println("End!");
    }

    public static void testTask(ExecutorService exec, int timeout) {
        MyTask task = new MyTask();
        Future<Boolean> future = exec.submit(task);
        Boolean taskResult = null;
        String failReason = null;
        try {
            // 等待计算结果，最长等待timeout秒，timeout秒后中止任务
            taskResult = future.get(timeout, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            failReason = "主线程在等待计算结果时被中断！";
        } catch (ExecutionException e) {
            failReason = "主线程等待计算结果，但计算抛出异常！";
        } catch (TimeoutException e) {
            failReason = "主线程等待计算结果超时，因此中断任务线程！";
            exec.shutdownNow();
        }

        System.out.println("\ntaskResult : " + taskResult);
        System.out.println("failReason : " + failReason);
    }
}

class MyTask implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        int i = 10;
        while (i<100){
            //Thread.sleep(100);
            System.out.print('-');
        }
        return Boolean.TRUE;
    }
}