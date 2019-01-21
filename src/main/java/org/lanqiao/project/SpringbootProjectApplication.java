package org.lanqiao.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@MapperScan("org.lanqiao.project.mapper")
public class SpringbootProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootProjectApplication.class, args);
    }

}

