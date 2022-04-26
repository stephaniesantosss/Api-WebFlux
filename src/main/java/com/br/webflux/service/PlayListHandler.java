package com.br.webflux.service;

import com.br.webflux.model.PlayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Component
public class PlayListHandler {

    @Autowired
    PlayListService playListService;

    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playListService.findAll(), PlayList.class);
    }

    public Mono<ServerResponse> findById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playListService.findById(id), PlayList.class);
    }

    public Mono<ServerResponse> savePlaylist(ServerRequest serverRequest) {
        final Mono<PlayList> playListMono = serverRequest.bodyToMono(PlayList.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playListMono.flatMap(playListService::save), PlayList.class));
    }
}
