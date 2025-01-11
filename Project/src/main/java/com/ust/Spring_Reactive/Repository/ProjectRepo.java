package com.ust.Spring_Reactive.Repository;

import com.ust.Spring_Reactive.entity.Project;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProjectRepo extends ReactiveMongoRepository<Project,String> {
}
