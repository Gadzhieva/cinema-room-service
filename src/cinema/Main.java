package cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    @Bean
    public Theater theater(){
        return new Theater();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("1");
    }
}
