package service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.model.Project;
import persistence.repository.IProjectRepository;
import service.IProjectService;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {
    @Autowired
    private IProjectRepository projectRepository;

    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Collection<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }}
