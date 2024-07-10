package com.yigbu.reactive_netflux.bootstrap;

import com.yigbu.reactive_netflux.domain.Movie;
import com.yigbu.reactive_netflux.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class InitMovies implements CommandLineRunner {
    private final MovieRepository movieRepository;
    @Override
    public void run(String... args) throws Exception {

        movieRepository.deleteAll().thenMany(Flux.just(
                "The dark night rises",
                "Everything everything",
                "Batman",
                "Superman vs Batman",
                "The fault in our stars"
        ))
                .map(title -> Movie.builder().title(title).build())
                .flatMap(movieRepository::save)
                .subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(System.out::println);
                });
    }
}
