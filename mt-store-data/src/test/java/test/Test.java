package test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author : shu
 * @description:
 * @date: 2020/6/21
 */
public class Test {


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            test();
        }

    }
    public static void test(){
        String url = "https://apimobile.meituan.com/group/v4/poi/pcsearch/96?uuid=d78fd7e6af69497eaa7d.1592748382.1.0.0&userid=-1&limit=64&offset=128&q=%25E9%2585%2592%25E5%25BA%2597&areaId=139&Referer=https://jn.meituan.com/%25E9%2585%2592%25E5%25BA%2597";

        Document document = null;
        try {
             document = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                    .header("Accept-Encoding", "identity")
                    .header("Host", "apimobile.meituan.com")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.1540.7603.3148 Safari/537.14")
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(document.text());
    }
}
