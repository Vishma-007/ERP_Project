package com.ust.Spring_Reactive.Repository;

import com.ust.Spring_Reactive.entity.POEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PORepo extends ReactiveMongoRepository<POEntity,String> {
}
