package marwa.projectservice;

import marwa.projectservice.clients.ProductBacklogRestClient;
import marwa.projectservice.entities.Project;
import marwa.projectservice.repo.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication @EnableFeignClients
public class ProjectServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProjectRepository projectRepository, ProductBacklogRestClient productBacklogRestClient) {
        return args -> {
            productBacklogRestClient.allProductBacklogs().forEach(pb->{
                Project project1= Project.builder()
                        .nameproject("projectmicroservice")
                        .description("application web")
                        .id(pb.getId())
                        .build();
                projectRepository.save(project1);
                /*Project project2= Project.builder()
                        .nameproject("projectsymfony")
                        .description("application web")
                        .id(pb.getId())
                        .build();
                projectRepository.save(project2);*/
            });

            projectRepository.findAll().forEach(System.out::println);
        };


    }
}
