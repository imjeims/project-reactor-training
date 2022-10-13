package com.project_reactor.operadores;

import com.project_reactor.ProjectReactorApplication;
import com.project_reactor.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.List;

public class Filtrado {

    private Logger log = LoggerFactory.getLogger(ProjectReactorApplication.class);

    public void filter() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Rodolfo", 27),
                new Persona(3, "Juan", 25)
        );

        Flux.fromIterable(personas)
                .filter(persona -> persona.getEdad() < 27)
                .subscribe(p -> log.info(p.toString()));
    }

    public void distinct() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(1, "Juan", 29),
                new Persona(3, "Juan", 25)
        );

        Flux.fromIterable(personas)
                .distinct()
                .subscribe(p -> log.info(p.toString()));
    }

    public void take() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Rodolfo", 27),
                new Persona(3, "Juan", 25)
        );

        Flux.fromIterable(personas)
                .take(5)
                .subscribe(p -> log.info(p.toString()));
    }

    public void takeLast() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Rodolfo", 27),
                new Persona(3, "Juan", 25)
        );

        Flux.fromIterable(personas)
                .takeLast(2)
                .subscribe(p -> log.info(p.toString()));
    }

    public void skip() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Rodolfo", 27),
                new Persona(3, "Juan", 25)
        );

        Flux.fromIterable(personas)
                .skip(4)
                .subscribe(p -> log.info(p.toString()));
    }

    public void skipLast() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Rodolfo", 27),
                new Persona(3, "Juan", 25)
        );

        Flux.fromIterable(personas)
                .skipLast(2)
                .subscribe(p -> log.info(p.toString()));
    }
}
