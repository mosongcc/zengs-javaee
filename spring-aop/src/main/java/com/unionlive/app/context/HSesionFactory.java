package com.unionlive.app.context;

/**
 *
 */
public class HSesionFactory {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String getCurrent(){
        return threadLocal.get();
    }

    public static void open(){
        threadLocal.set("threadLocal = ");
        threadLocal.remove();
    }


}
