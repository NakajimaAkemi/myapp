package controller.impl;

import controller.IProjectController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import persistence.model.Project;
import service.IProjectService;

import java.util.Collection;

@RestController
public class ProjectControllerImpl implements  IProjectController{
    IProjectService projectService;

    public ProjectControllerImpl(IProjectService projectService){
        this.projectService=projectService;
    }

    @Override
    public Project findOne(Long id) {
        return projectService.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    @Override
    public Collection<Project> findAll() {
        return projectService.findAll();
    }

    @Override
    public Project create(Project project) {
        return projectService.save(project);
    }
}
