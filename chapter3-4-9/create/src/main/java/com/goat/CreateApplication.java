package com.goat;

import com.goat.service.CreateLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:  创建 license.lic 证书 文件
 * @Description:  ApplicationRunner中run方法的参数为ApplicationArguments，而CommandLineRunner接口中run方法的参数为String数组
 * @author: Goat
 * @Date:   2018/12/14
 */
@SpringBootApplication
public class CreateApplication implements CommandLineRunner {
    @Autowired
    CreateLicenseService createLicenseService;

    public static void main(String[] args) {
        SpringApplication.run(CreateApplication.class);
    }

    @Override
    public void run(String... strings) {
        createLicenseService.doCreateLicense();
    }
}
