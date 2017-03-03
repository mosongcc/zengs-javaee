import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("start app");

        try {
            httpGet();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    public static void httpGet() throws IOException, NoSuchAlgorithmException {
        //HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(new SSLConnectionSocketFactory(SSLContext.getDefault())).build();
        HttpClient httpClient = HttpClients.createDefault();

        HttpGet request = new HttpGet("https://wx.qq.com/?&lang=zh_CN");


        HttpResponse httpResponse = httpClient.execute(request);

        System.out.println(EntityUtils.toString(httpResponse.getEntity()));

    }


    public static void httpPost() throws IOException {

        CookieStore cookieStore = new BasicCookieStore();
        cookieStore.addCookie(new BasicClientCookie("",""));
        HttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpPost request = new HttpPost("http://d1.web2.qq.com/channel/login2");

        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("",""));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");
        request.setEntity(entity);


        HttpResponse httpResponse = httpClient.execute(request);

        System.out.println(IOUtils.toString(httpResponse.getEntity().getContent()));

    }


}
