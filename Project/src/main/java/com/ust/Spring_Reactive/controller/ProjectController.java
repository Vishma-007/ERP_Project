package com.ust.Spring_Reactive.controller;

import com.ust.Spring_Reactive.dto.ProjectDto;
import com.ust.Spring_Reactive.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/addproject")
        public Mono<ProjectDto> addProject(@RequestBody Mono<ProjectDto> projectDtoMono){
            return projectService.addProject(projectDtoMono);
        }
    @GetMapping("/getproject")
    public Flux<ProjectDto> getAllProject(){
        return projectService.getAllProjects();
    }

    @GetMapping("/getproject/{id}")
    public Mono<ProjectDto> getProjectById(@PathVariable String id){
        return projectService.getProjectById(id);
    }
    @PutMapping("/updateproject/{id}")
    public Mono<ProjectDto> updateProject(@PathVariable String id, @RequestBody Mono<ProjectDto> projectDtoMono){
        return projectService.updateProject(id, projectDtoMono);
    }
    @DeleteMapping("/deleteproject/{id}")
    public Mono<Void> deleteProject(@PathVariable String id){
        return projectService.deleteProject(id);
    }

}
