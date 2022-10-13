package com.project_reactor.operadores;

import com.project_reactor.ProjectReactorApplication;
import com.project_reactor.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Matematicos {

    private Logger log = LoggerFactory.getLogger(ProjectReactorApplication.class);

    public void average() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Rodolfo", 27),
                new Persona(3, "Juan", 25)
        );

        Flux.fromIterable(personas)
                .collect(Collectors.averagingInt(Persona::getEdad))
                .subscribe(promedio -> log.info(promedio.toString()));
    }

    public void count() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Rodolfo", 27),
                new Persona(2, "Rodolfo", 27),
                new Persona(2, "Rodolfo", 27)
        );

        Flux.fromIterable(personas)
                .count()
                .subscribe(count -> log.info(count.toString()));
    }

    public void min() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Rodolfo", 27),
                new Persona(3, "Rodolfo", 11)
        );

        Flux.fromIterable(personas)
                .collect(Collectors.minBy(Comparator.comparing(Persona::getEdad)))
                .subscribe(count -> log.info(count.get().toString()));
    }
}
