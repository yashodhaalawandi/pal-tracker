package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class PalTrackerApplication {

   @Bean
   TimeEntryRepository timeEntryRepository()
   {
       return new InMemoryTimeEntryRepository();
   }


    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }












}