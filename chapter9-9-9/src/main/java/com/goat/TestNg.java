package com.goat;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
     * @Description:  排班
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/27
*/
public class TestNg {
    public  static final String HEADER_PREFIX = "Bearer ";
    public  static final String header = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NDkyMDI0MDcsImlhdCI6MTU0OTE5ODgwNywidXNlcm5hbWUiOiJhZG1pbiJ9.cNeeQsYzIZShSrCWt7M2x-HoPCLLYdZ60_96mF_bjUo ";

    @BeforeMethod
    public void beforeMethod(){

    }


    @Test
    public void test()  {
        String s = StringUtils.removeStart(header, HEADER_PREFIX);
        System.out.println(s);
    }

}
