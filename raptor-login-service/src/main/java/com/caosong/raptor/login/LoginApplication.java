package com.caosong.raptor.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author caosong
 * @Description //TODO
 * @Date 2021/4/9 16:13
 **/
@SpringBootApplication
@MapperScan("com.caosong.raptor.login.mapper")
public class LoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class);
    }
}
