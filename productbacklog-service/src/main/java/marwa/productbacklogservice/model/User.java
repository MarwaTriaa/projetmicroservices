package marwa.productbacklogservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class User {
    private Long userID;
    private String nom;
    private String prenom;
    private String mail;
    private String mdp;
    private UserRole role;
}
