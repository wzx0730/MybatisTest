package com.test.demo_ibatis.jsoup;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class SwatchTest {
    private final Logger log = Logger.getLogger(SwatchTest.class);

    @Test
    private String test01(String url){
        BufferedReader bufferedReader = null;
        try {
            URL target = new URL(url);
            log.debug("url: "+target.getPath());
            log.debug("协议: "+target.getProtocol());
            log.debug("主机为: "+target.getHost());
            log.debug("验证信息为: "+target.getAuthority());
            URLConnection urlConnection = target.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
            char[] arr = new char[1024*2];
            StringBuilder sb = new StringBuilder();
            int len;
            while ((len=bufferedReader.read(arr))!=-1){
                sb.append(new String(arr,0,len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bufferedReader!=null)
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Test
    public void test2(){

        String url="https://www.haotxt.com/xiaoshuo/0/2/96.html";
        String path="E:\\talisFiles";
        BufferedWriter bw = null;
        String menu;
        String next;
        int count=0;
        try {
             bw = new BufferedWriter(new FileWriter(new File(path+"\\"+System.currentTimeMillis()+".text"),true));
            while (true) {
                String html = test01(url);
                if (html==null){
                    log.debug("页面为空,无法解析");
                }
                Document document = Jsoup.parse(html);
                String title = document.select("div[id=title]").text();
                Elements content = document.select("div[id=content]");
                log.debug("正在解析章节: "+title);
                String contentHtml = content.html();
                contentHtml= contentHtml.replaceAll("<br>", "");
                contentHtml = contentHtml.replaceAll("&nbsp;", " ");
                bw.write(title+"\r\n");
                bw.write(contentHtml+"\r\n");

                Elements eles = document.select("div[id=footlink]").select("a");

                Element elementMenu = eles.get(1);
                Element elementNext = eles.get(2);
                menu =elementMenu.attr("href");
                next = elementNext.attr("href");
                log.debug("next: "+next);
                if (menu.contains(next)){
                    log.debug("已经解析到最后一个章节");
                    break;
                }
               count++;
                url="https://www.haotxt.com"+next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw!=null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("文档下载完毕,共"+count+"个文件");



    }
}
