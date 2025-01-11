package com.ust.Spring_Reactive.utils;

import com.ust.Spring_Reactive.dto.PODto;
import com.ust.Spring_Reactive.entity.POEntity;
import org.springframework.beans.BeanUtils;

public class AppUtlis {

    public static PODto entityToDto(POEntity project) {
        PODto projectDto1 = new PODto();
        BeanUtils.copyProperties(project, projectDto1);
       return projectDto1;
    }
    public static POEntity dtoToEntity(PODto projectDto) {
        POEntity project = new POEntity();
        BeanUtils.copyProperties(projectDto, project);
        return project;
    }
}
