package com.example.web.abc;

import com.example.web.abc.domain.User;

import com.example.web.abc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
  
    public static void main(String[] args) {
    	   SpringApplication.run(Application.class, args);
    }

    public void run(String... strings) throws Exception {
      
    	
    

    }
}
