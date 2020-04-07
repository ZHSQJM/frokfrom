package com.zhs;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 10:58
 * @package: com.zhs
 * @description:
 */

//@SpringBootApplication(scanBasePackages = {"com.zhs","com.handsmap"})
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@MapperScan("com.zhs.mapper")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
    }



}
