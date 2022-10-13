package com.project_reactor;

import com.project_reactor.model.Persona;
import com.project_reactor.operadores.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@SpringBootApplication
public class ProjectReactorApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(ProjectReactorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjectReactorApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		badPractices();
	}

	private void mono() {
		Mono.just(new Persona(1, "Pedro", 27))
				.subscribe(e -> log.info(e.toString()));
	}

	private void flux() {
		Flux.just(
				new Persona(1, "Pedro", 27),
				new Persona(2, "Carlos", 28)
		).subscribe(e -> log.info(e.toString()));;
	}

	private void onNext() {
		Flux.just(
				new Persona(1, "Pedro", 27),
				new Persona(2, "Carlos", 28)
		).doOnNext(persona -> log.info(persona.toString()))
				.subscribe();
	}

	public void badPractices() {
		Persona persona = Mono.just(new Persona(1, "Pedro", 27)).block();

		log.info(persona.toString());
	}

	public void defer(String test) {
		Flux.just(
						new Persona(1, "Pedro", 27),
						new Persona(2, "Carlos", 28)
				)
		.next();
	}
}
