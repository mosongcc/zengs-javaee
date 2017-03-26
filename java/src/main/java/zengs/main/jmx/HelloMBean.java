package zengs.main.jmx;

/**
 * Created by song on 2017/3/26.
 */
public interface HelloMBean {

    public String getName();
    public void setName(String name);
    public void printHello();
    public void printHello(String whoName);

}
