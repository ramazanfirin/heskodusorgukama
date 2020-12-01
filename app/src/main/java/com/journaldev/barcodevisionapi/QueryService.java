package com.journaldev.barcodevisionapi;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class QueryService {

    public static void main(String[] args) throws IOException {
        query();
    }

    public static void query() throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://portal.kayseri.bel.tr/kullanici/hes/hes.aspx");

        httpPost.addHeader("__EVENTTARGET","ctl00$ContentPlaceHolder1$btnAra");
        httpPost.addHeader("__VIEWSTATE","/wEPDwUKLTMzNDE3MDIzMw9kFgJmD2QWAgIDD2QWBAIJDxYCHgdWaXNpYmxlaGQCDQ9kFgICCQ8WAh4JaW5uZXJodG1sBYoBPGgyPkYxVTgyMzk2MTM8L2gyPiAgPGgxPjxiPlJpc2tsaSBEZcSfaWw8L2I+PC9oMT4gPC9icj4gPGg1PjxiPioqKioqKioqMDA2PC9iPiBLaW1saWsgTnVtYXJhbMSxIEtpxZ9pIDwvaDU+IDxoNT48Yj5SQSoqKiogRkkqKioqPC9iPjwvaDU+ZGS39v1VVdsjsfQn8tIoKCH3b/p28tWzUOSt4I3jcu94sQ==");
        httpPost.addHeader("__VIEWSTATEGENERATOR","6D608220");
        httpPost.addHeader("__VIEWSTATEGENERATOR","CA0B0334");
        httpPost.addHeader("__EVENTVALIDATION","wEdAAXoOtFwDYov1jmOVVpVyLdTt8dhf5WvfEiGrWdEvYOiwHktk");
        httpPost.addHeader("ctl00$ContentPlaceHolder1$hescode","F1U8239613");

        CloseableHttpResponse response = client.execute(httpPost);

        BufferedReader rd = new BufferedReader
                (new InputStreamReader(
                        response.getEntity().getContent()));

        String line = "";
        StringBuffer textView = new StringBuffer();
        while ((line = rd.readLine()) != null) {
            textView.append(line);
        }

        System.out.println(textView);

        client.close();

    }
}
