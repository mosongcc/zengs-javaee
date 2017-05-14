package com.zingson.proxy.server;

import jdk.internal.util.xml.impl.Input;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

/**
 * Socks5 代理服务
 */
public class Socks5ProxyServer {

    private ServerSocket serverSocket;
    Socket socket=null;
    ObjectInputStream  inputStream = null;

    private int prot = 8100;

    public Socks5ProxyServer(){
        try {
            serverSocket = new ServerSocket(prot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createServer(){
        new Socks5ProxyServer().service();
    }

    public void service(){
        System.out.println("Server 启动成功...");
        while (true) {


            DataInputStream dataInput = null;
            try {
                socket = serverSocket.accept();
                System.out.println();
                System.out.println("*******************************************************************");
                System.out.println("New connection accepted " + socket.getInetAddress() + ":" +socket.getPort());

                //socket.shutdownInput();


                //System.out.println(toString(inputStream));

               /* BufferedReader bd=new BufferedReader(new InputStreamReader(inputStream));
                String requestHeader;
                while((requestHeader=bd.readLine())!=null&&!requestHeader.isEmpty()) {
                    System.out.println(requestHeader);
                }*/

                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                pw.println("HTTP/1.1 200 OK");
                pw.println("Content-type:text/html;charset=utf-8");
                pw.println();
                pw.println("<h1>访问成功！</h1>");
                pw.flush();

                socket.shutdownOutput();
                System.out.println(IOUtils.toString(socket.getInputStream()));

            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                try{
                    if(socket!=null)
                        socket.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String toString(InputStream inputStream) throws IOException {
      /*  BufferedReader bd=new BufferedReader(new InputStreamReader(inputStream));
        String requestHeader;
        while((requestHeader=bd.readLine())!=null&&!requestHeader.isEmpty()) {
            System.out.println(requestHeader);
        }

        */
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        while((line = bufferedReader.readLine()) != null&&!line.isEmpty()) {
            stringBuilder.append(System.getProperty("line.separator"));
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

}
