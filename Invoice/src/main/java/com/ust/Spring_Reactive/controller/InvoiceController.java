package com.ust.Spring_Reactive.controller;

import com.ust.Spring_Reactive.dto.InvoiceDto;
import com.ust.Spring_Reactive.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/addinvoice")
        public Mono<InvoiceDto> addInvoice(@RequestBody Mono<InvoiceDto> invoiceDtoMono){
            return invoiceService.addInvoice(invoiceDtoMono);
        }
    @GetMapping("/getinvoice")
    public Flux<InvoiceDto> getAllInvoice(){
        return invoiceService.getAllInvoice();
    }

    @GetMapping("/getinvoice/{id}")
    public Mono<InvoiceDto> getInvoiceById(@PathVariable String id){
        return invoiceService.getInvoiceById(id);
    }
    @PutMapping("/updateinvoice/{id}")
    public Mono<InvoiceDto> updateInvoice(@PathVariable String id, @RequestBody Mono<InvoiceDto> invoiceDtoMono){
        return invoiceService.updateInvoice(id, invoiceDtoMono);
    }
    @DeleteMapping("/deleteinvoice/{id}")
    public Mono<Void> deleteInvoice(@PathVariable String id){
        return invoiceService.deleteInvoice(id);
    }

}
