package com.project_reactor.operadores;

import com.project_reactor.ProjectReactorApplication;
import com.project_reactor.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.List;

public class Combinacion {

    private Logger log = LoggerFactory.getLogger(ProjectReactorApplication.class);

    public void merge() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Rodolfo", 27),
                new Persona(3, "Juan", 25)
        );

        List<Persona> personas2 = List.of(
                new Persona(4, "Jaime", 28),
                new Persona(5, "Alejo", 27),
                new Persona(6, "Andres", 27)
        );

        Flux<Persona> flujo1 = Flux.fromIterable(personas);
        Flux<Persona> flujo2 = Flux.fromIterable(personas2);

        Flux<Integer> nativo = Flux.just(10, 20, 30);

        Flux.merge(flujo1, nativo)
                .subscribe(e -> log.info(e.toString()));
    }

    public void zip() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Rodolfo", 27),
                new Persona(3, "Juan", 25)
        );

        List<Persona> personas2 = List.of(
                new Persona(4, "Jaime", 28),
                new Persona(5, "Alejo", 27),
                new Persona(6, "Andres", 27)
        );

        Flux<Persona> flujo1 = Flux.fromIterable(personas);
        Flux<Persona> flujo2 = Flux.fromIterable(personas2);

        Flux.zip(flujo1, flujo2)
                .subscribe(tupla -> log.info("[Elemento tupla 1]  : ".concat(tupla.getT1().toString()).concat("  [Elemento tupla 2]: ").concat(tupla.getT2().toString())));
    }

    public void zipWith() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Rodolfo", 27),
                new Persona(3, "Juan", 25)
        );

        List<Persona> personas2 = List.of(
                new Persona(4, "Jaime", 28),
                new Persona(5, "Alejo", 27),
                new Persona(6, "Andres", 27)
        );

        Flux<Persona> flujo1 = Flux.fromIterable(personas);
        Flux<Persona> flujo2 = Flux.fromIterable(personas2);

        flujo1.zipWith(flujo2)
                .subscribe(tupla -> log.info("[Elemento tupla 1]  : ".concat(tupla.getT1().toString()).concat("  [Elemento tupla 2]: ").concat(tupla.getT2().toString())));
    }
}
