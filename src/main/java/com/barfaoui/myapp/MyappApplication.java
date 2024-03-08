package com.barfaoui.myapp;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import persistence.model.Project;
import persistence.repository.IProjectRepository;

import java.time.LocalDate;
import java.util.random.RandomGenerator;

@SpringBootApplication
@ComponentScan(basePackages = {"persistence","controller","service"})
public class MyappApplication implements ApplicationRunner {
	public static final RandomGenerator RND = RandomGenerator.getDefault();
	IProjectRepository projectRepository;

	public MyappApplication(IProjectRepository projectRepository){
		this.projectRepository=projectRepository;
	}
	public static void main(final String...args) {
		SpringApplication.run(MyappApplication.class, args);
	}

	public void run(ApplicationArguments args) throws  Exception{

		projectRepository.save(new Project((RND.nextLong()),"P1", LocalDate.now()));
		projectRepository.save(new Project((RND.nextLong()),"P2", LocalDate.now()));
		projectRepository.save(new Project((RND.nextLong()),"P3", LocalDate.now()));

	}


}
