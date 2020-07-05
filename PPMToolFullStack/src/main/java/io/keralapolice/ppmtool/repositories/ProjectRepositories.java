package io.keralapolice.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import io.keralapolice.ppmtool.domain.Project;

@Repository
public interface ProjectRepositories extends CrudRepository<Project, Long> {

    Project findByProjectIdentifier(String projectId);

    @Override
    Iterable<Project> findAll();


}
