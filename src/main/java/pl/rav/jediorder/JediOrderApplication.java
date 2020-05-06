package pl.rav.jediorder;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class JediOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JediOrderApplication.class, args);

    }

}
