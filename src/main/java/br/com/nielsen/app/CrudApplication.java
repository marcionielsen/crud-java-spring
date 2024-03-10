package br.com.nielsen.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {
//		SpringApplication.run(CrudApplication.class, args);

        SpringApplication application = new SpringApplication(CrudApplication.class);

        Map<String, Object> map = new HashMap<>();

        map.put("server.servlet.context-path", "/crudApi");
        map.put("server.port", "8080");

        application.setDefaultProperties(map);
        application.run(args);
    }
}
