package com.zengs.init;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 淘宝联盟推广链接生成
 */
public class Alimama {

    private static final String cookie = "cookie2=f9447d66b25d366e70ce97eea8175efe; t=8a312a3049bc462a511d13a0bc120bb3; v=0; _tb_token_=MIcu0eyPfOq; account-path-guide-s1=true; dxjh-guide-1=true; cookie32=775c150326882441ad624ab79b0c0c1a; cookie31=MzA0NDgwMjIsJUU2JTk4JTlGJUU2JUI1JUI3bHYxNjYseGluaGFpMTY2QHNpbmEuY29tLFRC; alimamapwag=TW96aWxsYS81LjAgKFdpbmRvd3MgTlQgMTAuMDsgV09XNjQpIEFwcGxlV2ViS2l0LzUzNy4zNiAoS0hUTUwsIGxpa2UgR2Vja28pIENocm9tZS81Mi4wLjI3NDMuODIgU2FmYXJpLzUzNy4zNiBPUFIvMzkuMC4yMjU2LjQ4; login=U%2BGCWk%2F75gdr5Q%3D%3D; alimamapw=R3JTEHIGRnd2ECAEW08EDwdrUgMHAQdQVAIHV1QADgtWXwEBUQFQBlMAVARRAVBTUls%3D; rurl=aHR0cDovL3B1Yi5hbGltYW1hLmNvbS8%2Fc3BtPWEyMTl0Ljc2NjQ1NTQuYTIxNHRyOC43LnI1eHAxQg%3D%3D; cna=w545EZEMLg0CASrE88+/KKlO; apush940b8d4e445d93bf2ed77505d7928abc=%7B%22ts%22%3A1488114667145%2C%22heir%22%3A1488114637075%2C%22parentId%22%3A1488111435776%7D; l=AvDwP/7aG1Cb2-sHgES0iR15QLVAu9SE; isg=AqCgELrd7FEFkVBVemRUUjSCYa6to6iolX3CAhqz7rtJFUQ_wLjjAe9j2wNo";
    private static final String adzoneid = "30132837";
    private static final String siteid = "5618618";

    public static void main(String[] args) {
        try {
            getAuctionCode("544386553725");
            //urltrans();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static HttpClient httpClient = HttpClients.createDefault();

    public static String getAuctionCode(String auctionid) throws IOException {
        long t = new Date().getTime();
        String url3 = "http://pub.alimama.com/common/code/getAuctionCode.json?auctionid="+auctionid+"&adzoneid="+adzoneid+"&siteid="+siteid+"&scenes=1&t="+t+"&pvid=10_42.196.243.207_433_"+t;
        String r3 = http(new HttpGet(url3));
        System.out.println("r3="+r3);

        //解析响应数据


        return "";
    }

    private static String http(HttpUriRequest http) throws IOException {
        http.setHeader("Accept","application/json, text/javascript, */*; q=0.01");
        http.setHeader("Cache-Control","no-cache");
        http.setHeader("Cookie",cookie);
        http.setHeader("Referer","http://pub.alimama.com/promo/search/index.htm"); //待修改为当前链接
        http.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.82 Safari/537.36 OPR/39.0.2256.48");
        http.setHeader("X-Requested-With","XMLHttpRequest");
        HttpResponse httpResponse = httpClient.execute(http);
        String result = EntityUtils.toString(httpResponse.getEntity());

        return result;
    }

    /**
     * 转换淘宝链接
     * @return
     * @throws IOException
     */
    public static String urltrans() throws IOException {

        String g = "https://detail.tmall.com/item.htm?spm=a220o.1000855.1998025129.2.Jbb3jU&abtest=_AB-LR32-PR32&pvid=ddecdb78-1383-475f-93b4-4b5d2309477a&pos=2&abbucket=_AB-M32_B9&acm=03054.1003.1.1285741&id=544441170107&scm=1007.12559.61743.100200300000000";
        String url = "http://pub.alimama.com/urltrans/urltrans.json?siteid=5618618&adzoneid=30132837&promotionURL="+g+"&t=1488111476677&pvid=52_42.196.243.207_6037_1488111466197&_tb_token_=MIcu0eyPfOq&_input_charset=utf-8";
        HttpGet http = new HttpGet(url);
        http.setHeader("Accept","application/json, text/javascript, */*; q=0.01");
        http.setHeader("Cache-Control","no-cache");
        http.setHeader("Cookie","cookie2=f9447d66b25d366e70ce97eea8175efe; t=8a312a3049bc462a511d13a0bc120bb3; v=0; _tb_token_=MIcu0eyPfOq; account-path-guide-s1=true; dxjh-guide-1=true; cookie32=775c150326882441ad624ab79b0c0c1a; cookie31=MzA0NDgwMjIsJUU2JTk4JTlGJUU2JUI1JUI3bHYxNjYseGluaGFpMTY2QHNpbmEuY29tLFRC; alimamapwag=TW96aWxsYS81LjAgKFdpbmRvd3MgTlQgMTAuMDsgV09XNjQpIEFwcGxlV2ViS2l0LzUzNy4zNiAoS0hUTUwsIGxpa2UgR2Vja28pIENocm9tZS81Mi4wLjI3NDMuODIgU2FmYXJpLzUzNy4zNiBPUFIvMzkuMC4yMjU2LjQ4; login=U%2BGCWk%2F75gdr5Q%3D%3D; alimamapw=R3JTEHIGRnd2ECAEW08EDwdrUgMHAQdQVAIHV1QADgtWXwEBUQFQBlMAVARRAVBTUls%3D; cna=w545EZEMLg0CASrE88+/KKlO; apush940b8d4e445d93bf2ed77505d7928abc=%7B%22ts%22%3A1488111476216%2C%22heir%22%3A1488111455231%2C%22parentId%22%3A1488111435776%7D; l=AhsbOkaXgAEk4tCm5/0/-OZoK3SGcC/y; isg=Al9fdiloe6R6PH-4URmjR483_rMR4j5kfuitL_Gve45VgHcC_ZWctKsWNK4D");
        http.setHeader("Referer","http://pub.alimama.com/promo/search/index.htm"); //待修改为当前链接
        http.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.82 Safari/537.36 OPR/39.0.2256.48");
        http.setHeader("X-Requested-With","XMLHttpRequest");
        HttpResponse httpResponse = httpClient.execute(http);
        String result = EntityUtils.toString(httpResponse.getEntity());
        System.out.println("淘宝联盟响应："+result);

        return "";
    }

}
