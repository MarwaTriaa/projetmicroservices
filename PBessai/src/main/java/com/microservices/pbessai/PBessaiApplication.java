package com.microservices.pbessai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.microservices.pbessai.entities.PBItem;
import com.microservices.pbessai.entities.ProductBacklog;
import com.microservices.pbessai.repo.PBItemRepository;
import com.microservices.pbessai.repo.ProductBacklogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PBessaiApplication {
    @Autowired
    private ProductBacklogRepository productBacklogRepository;

    @Autowired
    private PBItemRepository pbItemRepository;

    public static void main(String[] args) {
        SpringApplication.run(PBessaiApplication.class, args);
    }

    /*@Bean
    CommandLineRunner start(PBItemRepository pbItemRepository,ProductBacklogRepository productBacklogRepository){
        return args-> {
            pbItemRepository.save(new PBItem ())
        };
    }*/
    @Bean
    CommandLineRunner init(PBItemRepository pbItemRepository, ProductBacklogRepository productBacklogRepository) {
        return args -> {
            // Création d'un ProductBacklog
            ProductBacklog productBacklog = new ProductBacklog();
            productBacklog.setName("Backlog Example");
            productBacklogRepository.save(productBacklog);

            // Création d'un PBItem associé au ProductBacklog
            PBItem pbItem = new PBItem();
            pbItem.setName("Item Example");
            pbItem.setDescription("Example description");
            pbItem.setPriority(1);
            pbItem.setStatus("To Do");
            pbItem.setProductBacklog(productBacklog);
            pbItemRepository.save(pbItem);

            // Affichage de tous les PBItem
            System.out.println("Liste des PBItems : ");
            pbItemRepository.findAll().forEach(System.out::println);
        };
    }

}
