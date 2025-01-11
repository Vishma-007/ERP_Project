package com.ust.Spring_Reactive.service;

import com.ust.Spring_Reactive.Repository.InvoiceRepo;
import com.ust.Spring_Reactive.dto.InvoiceDto;

import com.ust.Spring_Reactive.utils.AppUtlis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepo repo;


    public Mono<InvoiceDto> addInvoice(Mono<InvoiceDto> invoiceDtomono) {
        return invoiceDtomono.map(AppUtlis::dtoToEntity)
                          .flatMap(repo::insert)
                .map(AppUtlis::entityToDto);
    }

    public Flux<InvoiceDto> getAllInvoice() {
        return repo.findAll().map(AppUtlis::entityToDto);
    }

    public Mono<InvoiceDto> getInvoiceById(String id) {
        return repo.findById(id).map(AppUtlis::entityToDto);
    }

    public Mono<InvoiceDto> updateInvoice(String id, Mono<InvoiceDto> invoicedtomono) {
        return repo.findById(id)
                .flatMap(p->invoicedtomono.map(AppUtlis::dtoToEntity)
                .doOnNext(e->e.setId(id))
                .flatMap(repo::save)
                .map(AppUtlis::entityToDto));
    }

    public Mono<Void> deleteInvoice(String id) {
        return repo.deleteById(id);
    }
}
