package com.hong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description     : Spring入口
 */
@SpringBootApplication
@ComponentScan({"com.hong.common","com.hong.repository","com.hong"})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class,args);
	}
}
