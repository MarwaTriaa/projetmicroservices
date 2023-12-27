package marwa.projectservice.web;

import marwa.projectservice.clients.ProductBacklogRestClient;
import marwa.projectservice.entities.Project;
import marwa.projectservice.model.ProductBacklog;
import marwa.projectservice.repo.ProjectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectRestController {
    private ProjectRepository projectRepository;
    private ProductBacklogRestClient productBacklogRestClient;
    public ProjectRestController(ProjectRepository projectRepository, ProductBacklogRestClient productBacklogRestClient){

        this.projectRepository= projectRepository;
        this.productBacklogRestClient = productBacklogRestClient;
    }
    @GetMapping("/projects")
    public List<Project> projectList (){

        List<Project> projectList = projectRepository.findAll();
        projectList.forEach(prj->{
            prj.setProductBacklog(productBacklogRestClient.findProductBacklogById(prj.getId()));
        });
        return projectList;
    }
    @GetMapping("/projects/{projectID}")
    public Project projectById(@PathVariable Long projectID){

        Project project=  projectRepository.findById(projectID).get(); //on cherche dans la db
        ProductBacklog productbacklog= productBacklogRestClient.findProductBacklogById(project.getId());

        project.setProductBacklog(productbacklog);
        return project;
    }
}
