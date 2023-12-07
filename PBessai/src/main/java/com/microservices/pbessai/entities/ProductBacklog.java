package com.microservices.pbessai.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class ProductBacklog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPB;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productBacklog")
    private List<PBItem> backlogItems;
}
