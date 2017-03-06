package generatory;

import java.io.IOException;

/**
 * Created by songz on 2017/3/6.
 */
public class Main {

    //java -jar F:\xy\jars\mybatis-generator-core-1.3.2.jar -configfile F:\xy\generator.xml -overwrite
    public static void main(String[] args) {

        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("java -jar F:\\xy\\jars\\mybatis-generator-core-1.3.2.jar -configfile F:\\xy\\generator.xml -overwrite");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
