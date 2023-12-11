package com.ms.pbacklog;
import com.ms.pbacklog.entity.ProductBacklog;
import com.ms.pbacklog.repo.PBRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PBacklogApplication {

    public static void main(String[] args) {
        SpringApplication.run(PBacklogApplication.class, args);
    }
    @Bean
    CommandLineRunner start(PBRepository pbRepository){
        return args -> {
            ProductBacklog newProductBacklog = new ProductBacklog();
            newProductBacklog.setName("Exemple de backlog");
            newProductBacklog.setDescription("Description du backlog");
            newProductBacklog.setPriority(1);
            newProductBacklog.setAssignedTo("Assigné à quelqu'un");
            newProductBacklog.setStatus("En cours");
            newProductBacklog.setCreationDate(new Date());
            newProductBacklog.setDueDate(new Date());

            // Sauvegarder le nouveau ProductBacklog
            pbRepository.save(newProductBacklog);

            // Afficher tous les ProductBacklogs
            pbRepository.findAll().forEach(System.out::println);
        };
    }


}
