package com.goat.B.B03.example01;
import org.testng.annotations.Test;

/**
 * Created by 64274 on 2018/7/7.
 *
 * @Description: TODO
 * @date 2018/7/7---19:04
 * 静态代理模式要点：
 * 1.  代理角色要持有真实角色的引用
 * 2.  二者实现同一个接口
 */
public class TestNG {
    @Test
    public void test(){
        Matchmaking matchmaking1 = new Matchmaking(new Bob());
        Matchmaking matchmaking2 = new Matchmaking(new Tom());
        matchmaking1.marry();
        matchmaking2.marry();
    }
}