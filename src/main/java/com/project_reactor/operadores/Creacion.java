package com.project_reactor.operadores;

import com.project_reactor.ProjectReactorApplication;
import com.project_reactor.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Creacion {

    private Logger log = LoggerFactory.getLogger(ProjectReactorApplication.class);

    public void justFrom() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 26),
                new Persona(2, "Juan", 28)
        );

        Flux.fromIterable(personas)
                .subscribe(p -> log.info(p.toString()));
    }

    public void empty() {
        Mono.empty()
                .subscribe(e -> log.info(e.toString()));

        Flux.empty()
                .subscribe(e -> log.info(e.toString()));
    }

    public void range() {
        Flux.range(0, 11)
                .subscribe(e -> log.info(e.toString()));
    }

    public void repeat() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 26),
                new Persona(2, "Juan", 28)
        );

        Flux.fromIterable(personas)
                .repeat(3)
                .subscribe(e -> log.info(e.toString()));
    }
}
