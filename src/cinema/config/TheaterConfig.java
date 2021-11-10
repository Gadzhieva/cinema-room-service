package cinema.config;

import cinema.repository.Theater;
import cinema.service.TheaterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TheaterConfig {
    @Bean
    public Theater theater() {
        return new Theater();
    }

    @Bean
    public TheaterService theaterService(Theater theater) {
        return new TheaterService(theater);
    }
}
