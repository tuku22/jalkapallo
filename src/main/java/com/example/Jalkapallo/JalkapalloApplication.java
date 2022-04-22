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
import com.example.Jalkapallo.domain.User;
import com.example.Jalkapallo.domain.UserRepository;


@SpringBootApplication
public class JalkapalloApplication {
	private static final Logger log = LoggerFactory.getLogger(JalkapalloApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JalkapalloApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(OtteluRepository repository, KenttaRepository krepository, UserRepository urepository) {
		return (args) -> {
			
			Kentta k1 = new Kentta("Kankola");
			Kentta k2 = new Kentta("Paavola");
			Kentta k3 = new Kentta("Mukkula");
			Kentta k4 = new Kentta("Liipola");
			Kentta k5 = new Kentta("Kispi");
			
			krepository.save(k1);
			krepository.save(k2);
			krepository.save(k3);
			krepository.save(k4);
			krepository.save(k5);
			
			repository.save(new Ottelu("12", "Ruola", "SC31", 2-1, "Alex Aura", krepository.findByName("Kankola").get(0)));
			
			 User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
	            User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
	            urepository.save(user1);
	            urepository.save(user2);
			 
			
			log.info("fetch ottelut");
			for(Ottelu ottelu : repository.findAll()) {
				log.info(ottelu.toString());
			}
		};
	}

}
