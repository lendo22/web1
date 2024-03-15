package com.cp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.cp.mapper")
public class SpringbootMySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMySqlApplication.class, args);
    }

}
