package com.project_reactor.operadores;

import com.project_reactor.ProjectReactorApplication;
import com.project_reactor.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class ControlErrores {

    private Logger log = LoggerFactory.getLogger(ProjectReactorApplication.class);

    public void retry() {
        Flux.just(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Rodolfo", 27),
                new Persona(3, "Juan", 25)
        ).concatWith(Flux.error(new RuntimeException("CUSTOM ERROR")))
                .retry(2)
                .doOnNext(e ->  log.info(e.toString()))
                .subscribe();

    }

    public void errorReturn() {
        Flux.just(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Rodolfo", 27),
                new Persona(3, "Juan", 25)
        )
        .concatWith(Flux.error(new RuntimeException("CUSTOM ERROR")))
                .onErrorReturn(new Persona(0, "ABC", 99))
                .subscribe(p -> log.info(p.toString()));
    }

    public void errorResume() {
        Flux.just(
                        new Persona(1, "Pedro", 29),
                        new Persona(2, "Rodolfo", 27),
                        new Persona(3, "Juan", 25)
                )
                .concatWith(Flux.error(new RuntimeException("CUSTOM ERROR")))
                .onErrorResume(e -> Mono.just(new Persona(0, "ABC", 99)))
                .subscribe(x -> log.info(x.toString()));
    }
}
