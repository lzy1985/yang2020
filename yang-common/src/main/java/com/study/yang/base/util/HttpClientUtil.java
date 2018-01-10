package com.study.yang.base.util;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/10/8 上午6:34
 * @Description
 */
public class HttpClientUtil {

    public static final String CONTENT_CHARSET = "utf-8";
    public static final Charset UTF_8 = Charset.forName("UTF-8");


    /**
     * 创建HttpClient
     *
     * @param isMultiThread
     * @return
     */
    private static CloseableHttpClient buildHttpClient(boolean isMultiThread) {
        CloseableHttpClient client;
        if (isMultiThread)
            client = HttpClientBuilder.create().setConnectionManager(new PoolingHttpClientConnectionManager()).build();
        else
            client = HttpClientBuilder.create().build();
        return client;
    }

    /**
     * post 发送表单数据
     *
     * @param parameters
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static String postData(String url, String parameters) throws ParseException, IOException {
        System.out.println("请求路径：" + url);
        System.out.println("请求参数：" + parameters);
        HttpPost method = new HttpPost(url);
        CloseableHttpClient client = buildHttpClient(false);
        String body = null;
        if (method != null & parameters != null && !"".equals(parameters.trim())) {
            method.setHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded");
            // 添加参数
            StringEntity entity = new StringEntity(parameters, CONTENT_CHARSET);
            entity.setContentEncoding(CONTENT_CHARSET);
            entity.setContentType("application/x-www-form-urlencoded");
            method.setEntity(entity);

            // 设置编码
            HttpResponse response = client.execute(method);

            int statusCode = response.getStatusLine().getStatusCode();
            body = EntityUtils.toString(response.getEntity(), UTF_8);
            System.out.println("返回结果：" + body);
            if (statusCode != HttpStatus.SC_OK) {
                throw new RuntimeException("http响应不是200!响应报文:" + body);
            }
        }
        return body;
    }

    /**
     * post 发送Json数据
     *
     * @param parameters
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static String postJson(String url, String parameters) throws ParseException, IOException {
        System.out.println("请求路径：" + url);
        System.out.println("请求参数：" + parameters);
        HttpPost method = new HttpPost(url);
        CloseableHttpClient client = buildHttpClient(false);
        String body = null;
        if (method != null & parameters != null && !"".equals(parameters.trim())) {
            // 添加参数
            StringEntity entity = new StringEntity(parameters, CONTENT_CHARSET);
            entity.setContentEncoding(CONTENT_CHARSET);
            entity.setContentType("application/json;charset=utf-8");
            method.setEntity(entity);
            // 设置编码
            HttpResponse response = client.execute(method);

            int statusCode = response.getStatusLine().getStatusCode();
            body = EntityUtils.toString(response.getEntity(), UTF_8);
            System.out.println("返回结果：" + body);
            if (statusCode != HttpStatus.SC_OK) {
                throw new RuntimeException("http响应不是200!响应报文:" + body);
            }
        }
        return body;
    }
}
