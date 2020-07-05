package io.keralapolice.ppmtool.services;

import io.keralapolice.ppmtool.domain.Project;
import io.keralapolice.ppmtool.exceptions.ProjectIdeException;
import io.keralapolice.ppmtool.repositories.ProjectRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepositories projectRepositories;

    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepositories.save(project);
        } catch (Exception e) {
            throw new ProjectIdeException("Project Id '" + project.getProjectIdentifier().toUpperCase() + "' already exist");
        }

    }

    public Project findProjectByIdentifier(String projectId){
        Project project = projectRepositories.findByProjectIdentifier(projectId.toUpperCase());
        if(project==null){
            throw new ProjectIdeException(projectId.toUpperCase() + "' Project Id Does Not Exist");
        }
        return project;
    }


    public Iterable<Project> findAllProjects(){
        return projectRepositories.findAll();
    }


    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepositories.findByProjectIdentifier(projectId.toUpperCase());
        if(project==null){
            throw new  ProjectIdeException("cannot find the project id "+projectId);

        }
        projectRepositories.delete(project);
    }

}
