package com.yigbu.reactive_netflux.repository;

import com.yigbu.reactive_netflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
