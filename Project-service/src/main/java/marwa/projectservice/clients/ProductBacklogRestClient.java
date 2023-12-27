package marwa.projectservice.clients;
import marwa.projectservice.model.ProductBacklog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name= "PRODUCTBACKLOG-SERVICE")
public interface ProductBacklogRestClient {
    @GetMapping("/api/productbacklogs/{id}")
    @CircuitBreaker(name = "productBacklogService", fallbackMethod = "getDefaultProductBacklog")
    ProductBacklog findProductBacklogById(@PathVariable Long id);
    @GetMapping("/api/productbacklogs")
    @CircuitBreaker(name = "productBacklogService", fallbackMethod = "getAllDefaultProductBacklog")
    List<ProductBacklog> allProductBacklogs();

    default ProductBacklog getDefaultProductBacklog(Long id, Exception exception){
        ProductBacklog productbacklog = new ProductBacklog();
        productbacklog.setId(id);
        productbacklog.setCreationDate(null);
        productbacklog.setDueDate(null);
        productbacklog.setPriority(0);
        productbacklog.setDescription("non disponible");
        productbacklog.setAssignedTo("non disponible");
        return productbacklog;
    }

    default List<ProductBacklog> getAllDefaultProductBacklog(Exception exception){

        return List.of();
    }
}
