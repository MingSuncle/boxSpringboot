package com.example.box;

import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMPP
public class BoxApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoxApplication.class, args);
    }

}
