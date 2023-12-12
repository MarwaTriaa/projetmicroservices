package marwa.userservice.entities;
import jakarta.persistence.*;
import lombok.*;
import marwa.userservice.enums.UserRole;

@ToString
@Getter
@Setter @Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity @Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    private String nom;
    private String prenom;
    private String mail;
    private String mdp;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
