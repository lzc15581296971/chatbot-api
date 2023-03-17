package com.lzc.chatbot.api.Test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @author 李智长
 * 单元测试
 *@author LiZhiChang
 *@Date 2023-02-27
 */
public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //回答问题的接口
        HttpGet get = new HttpGet("");
        //网站cookie值
        get.addHeader("cookie","zsxq_access_token=6EF5277D-6233-F718-6BD1-CA7F342B20BC_7EBD1661F0FE913E; zsxqsessionid=8f278695137a188a7d5b584068501ecf; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22841512114584452%22%2C%22first_id%22%3A%22186e6344e13345-0404d8edaf85cd-26031851-2073600-186e6344e1434e%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22%24device_id%22%3A%22186e6344e13345-0404d8edaf85cd-26031851-2073600-186e6344e1434e%22%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2ZTYzZGExZTA2Mi0wZmU3ZmY3MDI5OTNmYTgtMjYwMzE4NTEtMjA3MzYwMC0xODZlNjNkYTFlMTU4MiIsIiRpZGVudGl0eV9sb2dpbl9pZCI6Ijg0MTUxMjExNDU4NDQ1MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22841512114584452%22%7D%7D");
        get.addHeader("Content-Type","application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("");
        //网站cookie值
        post.addHeader("cookie","zsxq_access_token=6EF5277D-6233-F718-6BD1-CA7F342B20BC_7EBD1661F0FE913E; zsxqsessionid=8f278695137a188a7d5b584068501ecf; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22841512114584452%22%2C%22first_id%22%3A%22186e6344e13345-0404d8edaf85cd-26031851-2073600-186e6344e1434e%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22%24device_id%22%3A%22186e6344e13345-0404d8edaf85cd-26031851-2073600-186e6344e1434e%22%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2ZTYzZGExZTA2Mi0wZmU3ZmY3MDI5OTNmYTgtMjYwMzE4NTEtMjA3MzYwMC0xODZlNjNkYTFlMTU4MiIsIiRpZGVudGl0eV9sb2dpbl9pZCI6Ijg0MTUxMjExNDU4NDQ1MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22841512114584452%22%7D%7D");
        post.addHeader("Content-Type","application/json; charset=UTF-8");

        //设置回答答案
        String paramJson = "\"萨达萨\"";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("test/json","UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
    @Test
    public void test_chatGPT(){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("");

    }
}
