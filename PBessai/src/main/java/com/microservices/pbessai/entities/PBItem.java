package com.microservices.pbessai.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString


public class PBItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPBI;

    private String name;
    private String description;
    private int priority;
    private String assignedTo;
    private String status;
    private Date creationDate;
    private Date dueDate;

    @ManyToOne
    @JoinColumn(name = "product_backlog_id")
    private ProductBacklog productBacklog;

}