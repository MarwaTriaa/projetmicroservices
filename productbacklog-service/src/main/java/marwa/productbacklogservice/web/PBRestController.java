package marwa.productbacklogservice.web;

//import marwa.productbacklogservice.clients.UserRestClient;
import marwa.productbacklogservice.entities.ProductBacklog;
import marwa.productbacklogservice.repo.PBRepository;
import marwa.productbacklogservice.service.ProductBacklogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import marwa.productbacklogservice.model.User;


@RestController
@RequestMapping("/api")
public class PBRestController {
    private PBRepository pbRepository;
//    private UserRestClient userRestClient;

    public PBRestController(PBRepository pbRepository){
//        , UserRestClient userRestClient
        this.pbRepository= pbRepository;
//        this.userRestClient = userRestClient;
    }
    @GetMapping("/productbacklogs")
    public List<ProductBacklog> productBacklogList (){
        return pbRepository.findAll();
    }
    @GetMapping("/productbacklogs/{id}")
    public ProductBacklog productBacklogById(@PathVariable Long id){

        /*User user= userRestClient.findUserById(productBacklog.getUserID());
        productBacklog.setUser(user);*/
        return pbRepository.findById(id).get();
    }
    @PostMapping("/productbacklogs")
    public ProductBacklog addPB(@RequestBody ProductBacklog pb) {
        return pbRepository.save(pb);
    }
    @DeleteMapping("/productbacklogs/{id}")
    public ProductBacklog removePB(@PathVariable("id") Long id) {
        ProductBacklog pb = pbRepository.findById(id).orElse(null);
        if (pb != null) {
            pbRepository.delete(pb);
        }
        return pb;
    }
    @PutMapping("/productbacklogs")
    public ProductBacklog updatePB(@RequestBody ProductBacklog pb) {
        return pbRepository.findById(pb.getId())
                .map(existingPB -> {
                    existingPB.setName(pb.getName());
                    existingPB.setDescription(pb.getDescription());
                    // Ajoutez d'autres propriétés à mettre à jour selon vos besoins
                    return pbRepository.save(existingPB);
                })
                .orElse(null);
    }

}
