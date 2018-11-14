package com.goat;

import com.alibaba.fastjson.JSONObject;
import com.goat.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
     * @Description:  MockMvc 基于SpringMVC进行测试
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/11/8
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //开启MockMvc  否则报错 No qualifying bean of type 'org.springframework.test.web.servlet.MockMvc' available
public class ApplicationTests {

    @Autowired
    private MockMvc mockMvc; //注入 MockMvc

    @Test
    public void test1() throws Exception {

    }


    @Test
    public void test2() throws Exception {
        User user = new User("111","2222");
        String requestJson = JSONObject.toJSONString(user);
        //请求方式： post   请求url： /request/requestBody
        String responseString = mockMvc.perform(post("/request/requestBody").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andDo(print()) //打印效果
                .andExpect(status().isOk())  //预期状态
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }

}
