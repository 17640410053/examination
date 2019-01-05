package com.system.examination;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@MapperScan("com.system.examination.mapper")
public class ExaminationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExaminationApplication.class, args);
        System.out.println("服务已启动");
    }

}

