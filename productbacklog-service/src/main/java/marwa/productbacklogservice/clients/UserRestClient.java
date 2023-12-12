package marwa.productbacklogservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import marwa.productbacklogservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name= "USER-SERVICE")
public interface UserRestClient {

    @CircuitBreaker(name = "userService", fallbackMethod = "getDefaultUser")
    @GetMapping("/users/{userID}")
    User findUserById(@PathVariable Long userID);

    /*@GetMapping("/users/{id}")
    User findUserById(@PathVariable Long id);*/

    @GetMapping("/users")
    @CircuitBreaker(name = "userService", fallbackMethod = "getAllDefaultUser")
    List<User> allUsers();

    default User getDefaultUser(Long id, Exception exception){
        User user = new User();
        user.setUserID(id);
        user.setNom("non disponible");
        user.setPrenom("non disponible");
        user.setMail("non disponible");
        user.setMdp("non disponible");
        return user;
    }

    default List<User> getAllDefaultUser(Exception exception){
        return List.of();
    }

}
