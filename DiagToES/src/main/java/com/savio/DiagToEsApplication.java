package com.savio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.savio.diag.config.DaDiagBatchConfiguration;

@SpringBootApplication
public class DiagToEsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaDiagBatchConfiguration.class, args);
	}
}
