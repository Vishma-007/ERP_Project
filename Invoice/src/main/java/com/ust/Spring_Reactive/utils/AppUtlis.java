package com.ust.Spring_Reactive.utils;

import com.ust.Spring_Reactive.dto.InvoiceDto;
import com.ust.Spring_Reactive.entity.Invoice;
import org.springframework.beans.BeanUtils;

public class AppUtlis {

    public static InvoiceDto entityToDto(Invoice project) {
        InvoiceDto projectDto1 = new InvoiceDto();
        BeanUtils.copyProperties(project, projectDto1);
       return projectDto1;
    }
    public static Invoice dtoToEntity(InvoiceDto projectDto) {
        Invoice project = new Invoice();
        BeanUtils.copyProperties(projectDto, project);
        return project;
    }
}
