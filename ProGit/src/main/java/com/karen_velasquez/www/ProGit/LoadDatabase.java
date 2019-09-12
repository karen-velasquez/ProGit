package com.karen_velasquez.www.ProGit;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(MinibusRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new Minibus(4554, "Obrajes")));
      log.info("Preloading " + repository.save(new Minibus(123, "Estado Mayor")));
    };
  }
}