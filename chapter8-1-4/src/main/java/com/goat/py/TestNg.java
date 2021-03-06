package com.goat.py;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
     * @Description:  Java通过命令行 执行 Python 脚本 并获取执行结果
     * @author: Goat
     * @Param:
     * @Return:
     * @Date:   2018/9/27
*/
public class TestNg {

    @Test
    public void test() throws IOException, InterruptedException {
        // 要输入命令行的 命令内容
//        String args="python "+"E:\\Code\\Python\\MyPython\\PythonLearning\\234.py ";
        String args="python "+"E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter8-1-4\\src\\main\\java\\com\\goat\\234.py";
        Process process=Runtime.getRuntime().exec(args);
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line=in.readLine())!=null){
            result.append(line);
        }
        in.close();
        process.waitFor();
        System.out.println(result);// 返回命令行  执行结果
    }

}
