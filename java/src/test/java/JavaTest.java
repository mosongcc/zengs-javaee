
public class JavaTest{

    public static void main(String[] args) throws InterruptedException {
        for(int i=1;i<100000;i++){
            for(int j=1;j<100000;j++){
                Thread.sleep(1000);
            }
        }
    }
}