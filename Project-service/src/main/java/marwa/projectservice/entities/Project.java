package marwa.projectservice.entities;

import jakarta.persistence.*;
import lombok.*;
import marwa.projectservice.model.ProductBacklog;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "project_table")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectID;
    private String nameproject;
    private String description;
    @Transient
    private ProductBacklog productBacklog;
    private Long id;

}
