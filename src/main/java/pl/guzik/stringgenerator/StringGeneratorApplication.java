package pl.guzik.stringgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StringGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(StringGeneratorApplication.class, args);
        System.out.println("It's running");
    }

}
