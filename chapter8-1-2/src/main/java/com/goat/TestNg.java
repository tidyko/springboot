package com.goat;

import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/27
*/
public class TestNg {


    @BeforeMethod
    public void beforeMethod(){

    }


    @Test
    public void test(){
        LuaState L = LuaStateFactory.newLuaState();
        L.openLibs();
        // sos 这里需要使用 绝对路径才能正确调用 ！！！
        L.LdoFile("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter8-1-2\\src\\main\\java\\com\\goat\\test.lua");
        L.close();
    }

}
