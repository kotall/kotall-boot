package com.kotall.rms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 应用启动器
 *
 * @author aracwong
 * @date 2017年9月3日 上午1:53:12
 * @since 1.0.0
 */
@SpringBootApplication
@EnableTransactionManagement
public class RmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RmsApplication.class, args).start();
    }

}
