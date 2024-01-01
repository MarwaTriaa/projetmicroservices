package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.entity.Tasks;
import com.example.demo.repository.TasksRepository;

//import java.sql.Date;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TasksServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksServiceApplication.class, args);
	}
	@Autowired 
	private TasksRepository taskRepository;

	 @Bean
	    CommandLineRunner start(TasksRepository taskRepository){
	        return args -> {
	        	 Tasks newTask = new  Tasks();
	      
	        	 newTask.setDescription(" Task 1: analyse des besoins");
	        	 newTask.setPriority(1);
	        	 newTask.setAssignedTo("Assigné à quelqu'un");
	        	 newTask.setStatus("En cours d'exécution");
	        	 newTask.setCreationDate(new Date());
	        	 newTask.setDueDate (new Date()); 
	        	 
	 // Sauvegarder une nouvelle tâche
	 taskRepository.save(newTask);
			 
			 
	
	            // Afficher toutes les tâches
	        	 taskRepository.findAll().forEach(System.out::println);
	        };
	    }
	
	 /* ApplicationRunner init() { return (args)-> {

     // Sauvegarder une nouvelle tâche
 	 taskRepository.save(new Tasks(description: "Task1: analyse des besoins", priority: "1",assignedTo:"feriel",status:"en cours",creationDate: "12-12-2023",  dueDate:"31-12-2023"));*/

	
	
	
}
