package com.br.webflux.repository;

import com.br.webflux.model.PlayList;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListRepository extends ReactiveMongoRepository<PlayList, String> {
}
