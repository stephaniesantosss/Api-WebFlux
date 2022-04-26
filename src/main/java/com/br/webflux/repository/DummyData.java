package com.br.webflux.repository;

import com.br.webflux.model.PlayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class DummyData implements CommandLineRunner {

    private final PlayListRepository playListRepository;

    public DummyData(PlayListRepository playListRepository) {
        this.playListRepository = playListRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        playListRepository.deleteAll()
                .thenMany(
                        Flux.just("Api Rest Spring boot", "Deploy de uma aplicação Java no IBM Cloud",
                                        "Java 11", "Github", "Spring security", "Web service RestFull")
                                .map(nome -> new PlayList(UUID.randomUUID().toString(), nome))
                                .flatMap(playListRepository::save))
                .subscribe(System.out::println);
    }
}
