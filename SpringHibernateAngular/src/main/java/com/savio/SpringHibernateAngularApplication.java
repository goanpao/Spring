package com.savio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.savio.sha.dao.StudentRepository;
import com.savio.sha.model.Student;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories
public class SpringHibernateAngularApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringHibernateAngularApplication.class);
	
	@Autowired
	StudentRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateAngularApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner demo() {
//		return (args) -> {
//			// save a couple of customers
//			repository.save(new Student(5,"Jack", "/img/jack.jpg", "DC", "D-"));
//
//			// fetch all customers
//			log.info("Students found with findAll():");
//			log.info("-------------------------------");
//			for (Student student: repository.findAll()) {
//				log.info(student.toString());
//			}
//            log.info("");
//
//			// fetch an individual customer by ID
//			Student student = repository.findOne(1);
//			log.info("Student found with findOne(1L):");
//			log.info("--------------------------------");
//			log.info(student.toString());
//            log.info("");
//            
//		};
//	}
}
