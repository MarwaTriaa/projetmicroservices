package marwa.projectservice.web;

import marwa.projectservice.clients.ProductBacklogRestClient;
import marwa.projectservice.entities.Project;
import marwa.projectservice.model.ProductBacklog;
import marwa.projectservice.repo.ProjectRepository;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/projects")
    public Project addProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }
    @PutMapping("/projects/{projectID}")
    public Project updateProject(@PathVariable Long projectID, @RequestBody Project updatedProject) {
        return projectRepository.findById(projectID)
                .map(existingProject -> {
                    existingProject.setNameproject(updatedProject.getNameproject());
                    existingProject.setDescription(updatedProject.getDescription());
                    // Ajoutez d'autres propriétés à mettre à jour selon vos besoins
                    return projectRepository.save(existingProject);
                })
                .orElse(null);
    }
    @DeleteMapping("/projects/{projectID}")
    public Project removeProject(@PathVariable Long projectID) {
        Project project = projectRepository.findById(projectID).orElse(null);
        if (project != null) {
            projectRepository.delete(project);
        }
        return project;
    }

}
