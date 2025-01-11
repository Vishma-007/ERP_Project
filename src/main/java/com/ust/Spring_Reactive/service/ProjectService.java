package com.ust.Spring_Reactive.service;

import com.ust.Spring_Reactive.Repository.ProjectRepo;
import com.ust.Spring_Reactive.dto.ProjectDto;

import com.ust.Spring_Reactive.utils.AppUtlis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo repo;


    public Mono<ProjectDto> addProject(Mono<ProjectDto> projectDtomono) {
        return projectDtomono.map(AppUtlis::dtoToEntity)
                          .flatMap(repo::insert)
                .map(AppUtlis::entityToDto);
    }

    public Flux<ProjectDto> getAllProjects() {
        return repo.findAll().map(AppUtlis::entityToDto);
    }

    public Mono<ProjectDto> getProjectById(String id) {
        return repo.findById(id).map(AppUtlis::entityToDto);
    }

    public Mono<ProjectDto> updateProject(String id, Mono<ProjectDto> projectdtomono) {
        return repo.findById(id)
                .flatMap(p->projectdtomono.map(AppUtlis::dtoToEntity)
                .doOnNext(e->e.setId(id))
                .flatMap(repo::save)
                .map(AppUtlis::entityToDto));
    }

    public Mono<Void> deleteProject(String id) {
        return repo.deleteById(id);
    }
}
