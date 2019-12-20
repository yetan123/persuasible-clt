package com.simplify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan("com.simplify.mapper")
@EnableAuthorizationServer
public class PersuasibleCrmApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersuasibleCrmApplication.class, args);
        Logger logger = LoggerFactory.getLogger(PersuasibleCrmApplication.class);
        logger.info("localhost:9624/");
    }

}
