package com.savio.batch.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.savio.spring.config.TLBatchConfig;

@ComponentScan
@EnableAutoConfiguration
public class TlToESApp {	
	public static void main(String[] args) {		
        SpringApplication.run(TLBatchConfig.class, args);
	}	
}
