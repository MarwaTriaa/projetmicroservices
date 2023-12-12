package marwa.userservice.web;
import marwa.userservice.entities.User;
import marwa.userservice.repo.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserRestController {
    private UserRepository userRepository;
    public UserRestController(UserRepository userRepository){
        this.userRepository= userRepository;
    }
    @GetMapping ("/users")
    public List<User> userList(){
        return userRepository.findAll();
    }
    @GetMapping ("/users/{userID}")
    public User userListById(@PathVariable Long userID){
        return userRepository.findById(userID).get();
    }
}
