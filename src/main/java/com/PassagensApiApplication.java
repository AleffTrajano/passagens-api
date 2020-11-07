package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.gama.passagens.project.start.Start;

@SpringBootApplication
//@EnableFeignClients
public class PassagensApiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PassagensApiApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner run( Start st) {
        return args -> {
        	st.init();
        	
        };
    }
}
