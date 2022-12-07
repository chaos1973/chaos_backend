package com.chaos.minio;

import com.chaos.minio.controller.UploadController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MinioApplication {
    public static void main(String[] args) {
        ApplicationContext  applicationContext = SpringApplication.run(MinioApplication.class, args);
        String beans [] = applicationContext.getBeanDefinitionNames();
        for (String bean: beans){
            System.out.println(bean);
        }


    }
    public static void test(){

    }

}
