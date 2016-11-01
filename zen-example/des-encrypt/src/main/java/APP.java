/**
 *
 */
public class APP {

    private static String message = null;
    private static String mac = "DES/CBC/PKCS5Padding";
    private static String key = "1qaz@WSX";

    public static void main(String[] args) {
        if(args.length==1||(args.length==2&&"0".equals(args[1]))){
            message = args[0];
            System.out.println(DesHelper.encrypt(message,mac,key));
            return;
        }
        if(args.length==2&&"1".equals(args[1])){
            System.out.println(DesHelper.decrypt(args[0],mac,key));
            return;
        }

        System.out.println("Error: Please set the encryption for content ");
        System.out.println("Example: java -jar des-encrypt.jar <content> <1| 0> ");

    }

}
