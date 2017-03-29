package zengs.main;

/**
 *
 */
public class APP {

    public static void main(String[] args) {
        Integer a = 1000,b=1000;
        System.out.println(a==b);
        Integer c = 100,d=100;
        System.out.println(c==d);


       new Thread(new Runnable() {
            @Override
            public void run() {
                //APP.method();//假如这个方法需要3分钟才执行完
            }
        }).start();

    }

}

