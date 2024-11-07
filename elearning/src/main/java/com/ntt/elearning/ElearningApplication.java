package com.ntt.elearning;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;

@SpringBootApplication
public class ElearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElearningApplication.class, args);
    }

    @Bean
    public Cloudinary getCloudinary() {
        Map config = new HashMap();
        config.put("cloud_name", "dtatqtclj");
        config.put("api_key", "544818839576415");
        config.put("api_secret", "wM-q_n3w69O-YrF7Zk60XSzPNrE");
        return new Cloudinary(config);
    }
}
