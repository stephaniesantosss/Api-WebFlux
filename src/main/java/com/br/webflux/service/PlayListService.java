package com.br.webflux.service;

import com.br.webflux.model.PlayList;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayListService {

    Flux<PlayList> findAll();

    Mono<PlayList> findById(String id);

    Mono<PlayList> save(PlayList playList);
}
