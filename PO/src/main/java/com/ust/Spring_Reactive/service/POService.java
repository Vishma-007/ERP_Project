package com.ust.Spring_Reactive.service;

import com.ust.Spring_Reactive.Repository.PORepo;
import com.ust.Spring_Reactive.dto.PODto;

import com.ust.Spring_Reactive.utils.AppUtlis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class POService {
    @Autowired
    private PORepo repo;


    public Mono<PODto> addPo(Mono<PODto> poDtomono) {
        return poDtomono.map(AppUtlis::dtoToEntity)
                          .flatMap(repo::insert)
                .map(AppUtlis::entityToDto);
    }

    public Flux<PODto> getAllPo() {
        return repo.findAll().map(AppUtlis::entityToDto);
    }

    public Mono<PODto> getPoById(String id) {
        return repo.findById(id).map(AppUtlis::entityToDto);
    }

    public Mono<PODto> updatePo(String id, Mono<PODto> podtomono) {
        return repo.findById(id)
                .flatMap(p->podtomono.map(AppUtlis::dtoToEntity)
                .doOnNext(e->e.setId(id))
                .flatMap(repo::save)
                .map(AppUtlis::entityToDto));
    }

    public Mono<Void> deletePo(String id) {
        return repo.deleteById(id);
    }
}
