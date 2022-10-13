package com.project_reactor.operadores;

import com.project_reactor.ProjectReactorApplication;
import com.project_reactor.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Transformacion {

    private Logger log = LoggerFactory.getLogger(ProjectReactorApplication.class);

    public void map() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Juan", 25)
        );

        Flux.fromIterable(personas)
                .map(persona -> {
                    persona.setEdad(persona.getEdad() + 10);
                    return persona;
                })
        .subscribe(p -> log.info(p.toString()));
    }

    public void flatMap() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Juan", 25)
        );

        Flux.fromIterable(personas)
                .flatMap(persona -> {
                    persona.setEdad(persona.getEdad() + 10);
                    return Mono.just(persona);
                }).subscribe(p -> log.info(p.toString()));
    }

    public void groupBy() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(1, "Johan", 27),
                new Persona(2, "Juan", 25)
        );

        Flux.fromIterable(personas)
                .groupBy(Persona::getId)
                .flatMap(Flux::collectList)
                .subscribe(p -> log.info(p.toString()));
    }
}
