package com.ust.Spring_Reactive.utils;

import com.ust.Spring_Reactive.dto.ProjectDto;
import com.ust.Spring_Reactive.entity.Project;
import org.springframework.beans.BeanUtils;

public class AppUtlis {

    public static ProjectDto entityToDto(Project project) {
        ProjectDto projectDto1 = new ProjectDto();
        BeanUtils.copyProperties(project, projectDto1);
       return projectDto1;
    }
    public static Project dtoToEntity(ProjectDto projectDto) {
        Project project = new Project();
        BeanUtils.copyProperties(projectDto, project);
        return project;
    }
}
