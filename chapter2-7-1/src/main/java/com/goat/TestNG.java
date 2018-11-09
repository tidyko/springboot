package com.goat;


import com.goat.pojo.HttpClientResult;
import com.goat.utils.HttpClientUtils;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


/**
     * @Description:  需先启动 chapter0-0-0  项目  后 方可进行测试
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/22
*/
@ContextConfiguration(classes= Application.class)
public class TestNG {
    /**
     * Description: 测试get无参请求
     * @throws Exception
     */
    @Test
    public void testGet() throws Exception {
        HttpClientResult result = HttpClientUtils.doGet("http://127.0.0.1:8888/hello/get");
        System.out.println(result);
    }

    /**
     * Description: 测试get带参请求
     * @throws Exception
     */
    @Test
    public void testGetWithParam() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("message", "helloworld");
        HttpClientResult result = HttpClientUtils.doGet("http://127.0.0.1:8888/hello/getWithParam", params);
        System.out.println(result);
    }

    /**
     * Description: 测试post带请求头不带请求参数
     * @throws Exception
     */
    @Test
    public void testPost() throws Exception {
        Map<String, String> headers = new HashMap<>();
        headers.put("Cookie", "123");
        headers.put("Connection", "keep-alive");
        headers.put("Accept", "application/json");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
        HttpClientResult result = HttpClientUtils.doPost("http://127.0.0.1:8888/hello/post", headers, null);
        System.out.println(result);
    }

    /**
     * Description: 测试post带参请求
     * @throws Exception
     */
    @Test
    public void testPostWithParam() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("code", "0");
        params.put("message", "helloworld");
        HttpClientResult result = HttpClientUtils.doPost("http://127.0.0.1:8888/hello/postWithParam", params);
        System.out.println(result);
    }
}
