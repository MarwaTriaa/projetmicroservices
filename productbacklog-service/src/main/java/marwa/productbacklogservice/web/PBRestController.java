package marwa.productbacklogservice.web;

import marwa.productbacklogservice.clients.UserRestClient;
import marwa.productbacklogservice.entities.ProductBacklog;
import marwa.productbacklogservice.repo.PBRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import marwa.productbacklogservice.model.User;


@RestController
@RequestMapping("/api")
public class PBRestController {
    private PBRepository pbRepository;
    private UserRestClient userRestClient;

    public PBRestController(PBRepository pbRepository, UserRestClient userRestClient){

        this.pbRepository= pbRepository;
        this.userRestClient = userRestClient;
    }
    @GetMapping("/productbacklogs")
    public List<ProductBacklog> productBacklogList (){
        return pbRepository.findAll();
    }
    @GetMapping("/productbacklogs/{id}")
    public ProductBacklog productBacklogById(@PathVariable Long id){

        ProductBacklog productBacklog=  pbRepository.findById(id).get(); //on cherche dans la db
        User user= userRestClient.findUserById(productBacklog.getUserID());
        productBacklog.setUser(user);
        return productBacklog;
    }

}
