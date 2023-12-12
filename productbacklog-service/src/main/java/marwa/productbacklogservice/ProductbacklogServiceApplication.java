package marwa.productbacklogservice;

import marwa.productbacklogservice.clients.UserRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import marwa.productbacklogservice.entities.ProductBacklog;
import marwa.productbacklogservice.repo.PBRepository;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class ProductbacklogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductbacklogServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(PBRepository pbRepository){
        return args -> {
            Date currentDate = new Date();
            // Date d'échéance (mettez une date future, par exemple)
            Date dueDate = new Date(currentDate.getTime() + 86400000); // Ajoutez un jour à la date actuelle

                ProductBacklog productbacklog1 = ProductBacklog.builder()
                        .name("ProductBacklog1")
                        .description("Description du backlog")
                        .priority(5)
                        .assignedTo("developpeur 1")
                        .status("en cours")
                        .creationDate(currentDate)
                        .dueDate(dueDate)
                        .userID(1L)
                        .build();
                pbRepository.save(productbacklog1);
                ProductBacklog productbacklog2 = ProductBacklog.builder()
                        .name("ProductBacklog2")
                        .description("Description du backlog 2")
                        .priority(3)
                        .assignedTo("developpeur 2")
                        .status("à faire")
                        .creationDate(new Date())
                        .dueDate(new Date(currentDate.getTime() + 2 * 86400000)) // Ajoutez deux jours à la date actuelle
                        .userID(2L)
                        .build();
                pbRepository.save(productbacklog2);



        };
    }
}
