package marwa.projectservice.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import marwa.projectservice.entities.Project;



public interface ProjectRepository extends JpaRepository<Project,Long>{
}
