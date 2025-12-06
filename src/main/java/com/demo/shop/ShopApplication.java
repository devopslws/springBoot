package com.demo.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //CreatedDate, LastModifiedDate 애너테이션 활용을 위한 설정 추가
public class ShopApplication {

	public static void main(String[] args) {

        ApplicationContext ac = SpringApplication.run(ShopApplication.class, args);
        String[] allBeans =  ac.getBeanDefinitionNames();
	}

}
