package com.project_reactor.operadores;

import com.project_reactor.ProjectReactorApplication;
import com.project_reactor.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

public class Condicionales {

    private Logger log = LoggerFactory.getLogger(ProjectReactorApplication.class);

    public void defaultEmpty() {
        Mono.empty()
                .defaultIfEmpty(new Persona(0, "Pedro", 99))
                .subscribe(x -> log.info(x.toString()));
    }

    public void switchIfEmpty() {
        Mono.empty()
                .switchIfEmpty(Mono.error(new RuntimeException("Custom error")))
                .subscribe(x -> log.info(x.toString()));
    }

    public void takeUntil() {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Rodolfo", 29),
                new Persona(3, "Juan", 25)
        );
        Flux.fromIterable(personas)
                .takeUntil(p -> p.getEdad() < 28)
                .subscribe(x -> log.info(x.toString()));
    }

    public void timeout() throws InterruptedException {
        List<Persona> personas = List.of(
                new Persona(1, "Pedro", 29),
                new Persona(2, "Rodolfo", 29),
                new Persona(3, "Juan", 25)
        );

        Flux.fromIterable(personas)
                .delayElements(Duration.ofSeconds(1))
                .timeout(Duration.ofSeconds(2))
                .subscribe(x -> log.info(x.toString()));

        Thread.sleep(10000);
    }
}
