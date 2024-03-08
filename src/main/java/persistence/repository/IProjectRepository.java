package persistence.repository;
import org.springframework.stereotype.Component;
import persistence.model.Project;

import java.util.Optional;

import java.util.Collection;
public interface IProjectRepository {

    Optional<Project> findById(Long id);

    Collection<Project> findAll();

    Project save(Project project);
}