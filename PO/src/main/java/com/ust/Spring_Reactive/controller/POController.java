package com.ust.Spring_Reactive.controller;

import com.ust.Spring_Reactive.dto.PODto;
import com.ust.Spring_Reactive.service.POService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/po")
public class POController {
    @Autowired
    private POService poService;

    @PostMapping("/addpo")
        public Mono<PODto> addPo(@RequestBody Mono<PODto> poDtoMono){
            return poService.addPo(poDtoMono);
        }
    @GetMapping("/getpo")
    public Flux<PODto> getAllPo(){
        return poService.getAllPo();
    }

    @GetMapping("/getpo/{id}")
    public Mono<PODto> getPoById(@PathVariable String id){
        return poService.getPoById(id);
    }
    @PutMapping("/updatepo/{id}")
    public Mono<PODto> updatePo(@PathVariable String id, @RequestBody Mono<PODto> poDtoMono){
        return poService.updatePo(id, poDtoMono);
    }
    @DeleteMapping("/deletepo/{id}")
    public Mono<Void> deletePo(@PathVariable String id){
        return poService.deletePo(id);
    }

}
