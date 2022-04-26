package com.br.webflux.controller;

import com.br.webflux.model.PlayList;
import com.br.webflux.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
public class PlayListController {

    @Autowired
    PlayListService playListService;

    @GetMapping("/playlist")
    public Flux<PlayList> getPlayList() {
        return playListService.findAll();
    }

    @GetMapping("/playlist/{id}")
    public Mono<PlayList> getPlaylistId(@PathVariable String id) {
        return playListService.findById(id);
    }

    @PostMapping("/playlist")
    public Mono<PlayList> savePlaylist(@RequestBody PlayList playList) {
        return playListService.save(playList);
    }

    @GetMapping(value = "/playlist/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, PlayList>> getPlaylistByEvents() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<PlayList> events = playListService.findAll();
        System.out.println("Passou aqui events");
        return Flux.zip(interval, events);
    }
}
