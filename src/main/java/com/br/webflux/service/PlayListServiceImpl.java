package com.br.webflux.service;

import com.br.webflux.model.PlayList;
import com.br.webflux.repository.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayListServiceImpl implements PlayListService {

    @Autowired
    PlayListRepository playListRepository;

    @Override
    public Flux<PlayList> findAll() {
        return playListRepository.findAll();
    }

    @Override
    public Mono<PlayList> findById(String id) {
        return playListRepository.findById(id);
    }

    @Override
    public Mono<PlayList> save(PlayList playList) {
        return playListRepository.save(playList);
    }
}
