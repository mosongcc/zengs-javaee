package zengs.main;

public class TestThread2 {

    public static void main(String[] args) {

       Thread thread = new Thread(new Runnable() {
           @Override
           public void run() {
                while (true){
                    System.out.print("-");
                }
           }
       });
       thread.start();
       thread.stop();
    }

}
