package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author LIU
 *
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class DubboZKCustomerApplication {

	public static void main(String[] args) {
		// 程序启动入口
		// 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		ConfigurableApplicationContext run = SpringApplication.run(DubboZKCustomerApplication.class, args);
		// CityDubboConsumerService cityService =
		// run.getBean(CityDubboConsumerService.class);
	}
}
