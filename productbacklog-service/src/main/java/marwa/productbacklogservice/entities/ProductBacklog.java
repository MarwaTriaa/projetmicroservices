package marwa.productbacklogservice.entities;
import jakarta.persistence.*;
import marwa.productbacklogservice.model.*;
import lombok.*;

import java.util.Date;
//import java.time.LocalDate;
@ToString
@Getter
@Setter @Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class ProductBacklog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int priority;
    private String assignedTo;
    private String status;
    private Date creationDate;
    private Date dueDate;
    /*@Transient
    private User user;
    private Long userID;*/

}
