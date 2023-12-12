package marwa.productbacklogservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import marwa.productbacklogservice.entities.ProductBacklog;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
public interface PBRepository extends JpaRepository<ProductBacklog,Long> {
}
