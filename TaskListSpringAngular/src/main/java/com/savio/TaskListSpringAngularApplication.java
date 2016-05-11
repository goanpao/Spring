package com.savio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.savio.model.Task;
import com.savio.model.TaskRepository;

@SpringBootApplication
@EnableJpaRepositories
public class TaskListSpringAngularApplication {

	private static final Logger log = LoggerFactory.getLogger(TaskListSpringAngularApplication.class);
	
	@Autowired
	TaskRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(TaskListSpringAngularApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			// fetch all tasks
			log.info("Tasks found with findAll():");
			log.info("-------------------------------");
			for (Task task: repository.findAll()) {
				log.info(task.toString());
			}
            log.info("");            
		};
	}

}
