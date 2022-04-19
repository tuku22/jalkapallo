package com.example.Jalkapallo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Jalkapallo.domain.Kentta;
import com.example.Jalkapallo.domain.KenttaRepository;
import com.example.Jalkapallo.domain.Ottelu;
import com.example.Jalkapallo.domain.OtteluRepository;

@SpringBootApplication
public class JalkapalloApplication {
	private static final Logger log = LoggerFactory.getLogger(JalkapalloApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JalkapalloApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(OtteluRepository repository, KenttaRepository krepository) {
		return (args) -> {
			log.info("tallenna muutama ottelu");
			krepository.save(new Kentta("Kankola"));
			repository.save (new Ottelu("Ruola", "SC31", 2-1, krepository.findById(0).get(0), "Alex Aura"));
			
			log.info("fetch ottelut");
			for(Ottelu ottelu : repository.findAll()) {
				log.info(ottelu.toString());
			}
		};
	}

}
