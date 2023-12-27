package marwa.projectservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ProductBacklog {
    private Long id;

    private String name;
    private String description;
    private int priority;
    private String assignedTo;
    private String status;
    private Date creationDate;
    private Date dueDate;
}
