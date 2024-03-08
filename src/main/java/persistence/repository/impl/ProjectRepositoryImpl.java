package persistence.repository.impl;

import java.util.ArrayList;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import persistence.model.Project;
import persistence.repository.IProjectRepository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Repository
public class ProjectRepositoryImpl implements IProjectRepository {
    private final List<Project> projects = new ArrayList<>();

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public Collection<Project> findAll() {
        return projects;
    }

    @Override
    public Project save(Project project) {
        Optional<Project> existingProject = findById(project.getId());
        if (existingProject.isPresent()) {
            projects.remove(existingProject);
        }
        Project newProject = new Project(project);
        projects.add(newProject);
        System.out.println("hello 22222\n");
        return newProject;
    }

    @PostConstruct
    public void  postConstruct(){
        //log.info("hello");
        System.out.print("hello\n");
    }
}