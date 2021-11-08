package cinema;

import cinema.repository.Theater;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    @Bean
    public Theater theater() {
        return new Theater();
    }

    @Bean
    public TheaterService theaterService(Theater theater) {
        return new TheaterService(theater);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("1");
    }
}
