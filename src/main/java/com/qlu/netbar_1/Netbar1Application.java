package com.qlu.netbar_1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qlu.netbar_1.mapper")
public class Netbar1Application {

    public static void main(String[] args) {
        SpringApplication.run(Netbar1Application.class, args);
    }

}
