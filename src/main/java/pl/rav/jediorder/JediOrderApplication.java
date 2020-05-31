package pl.rav.jediorder;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import pl.rav.jediorder.warrior.SwapiWarriorByID;

@Log4j2
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class JediOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JediOrderApplication.class, args);

        // Was trying to use WebClient, as the RequestTemplate is going to be depreciated... but noi success :(
//        WebClient client = WebClient.create("https://swapi.dev/api");                           //Creating a WebClient instance
//        WebClient.UriSpec<WebClient.RequestBodySpec> request = client.method(HttpMethod.GET);   // Preparing a request
//        WebClient.RequestBodySpec uri = client.method(HttpMethod.POST).uri("/people/1/");
//        String response = request.retrieve().block().bodyToMono(String.class).block();


//        // Same with RestTemplate
//        RestTemplate restTemplate = new RestTemplate();
//        SwapiWarrior test1 = restTemplate.getForObject("https://swapi.dev/api/people/2/", SwapiWarrior.class);
//        log.info(test1.getName() + " : " + test1);
//
////        ClientHttpRequest clientHttpRequest = new ClientHttpRequest.createRequest("https://swapi.dev/api/people", HttpMethod.GET);
//        SwapiWarrior test2 = new RestTemplate().getForObject("https://swapi.dev/api/people/3/", SwapiWarrior.class);
//        log.info(test2.getName() + " : " + test2);
//
//        // single request by id
//        SwapiWarrior test4 = new RestTemplate().getForObject("https://swapi.dev/api/{resource}/{id}/", SwapiWarrior.class, "people","3");
//        log.info(test4.getName() + " : " + test4);
//
//        // request by map
//        Map<String, String> requestSkywalker = new HashMap<>();
//        requestSkywalker.put("resource", "people");
//        requestSkywalker.put("id", "1");
//        SwapiWarrior test5 = new RestTemplate().getForObject("https://swapi.dev/api/{resource}/{id}/", SwapiWarrior.class, requestSkywalker);
//        log.info(test5.getName() + " : " + test5);



//        SwapiWarrior test3 = new RestTemplate().getForObject("https://swapi.dev/api/people/?search=r2", SwapiWarrior.class);
//        log.info(test3.getName() + " : " + test3);

    }




    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            SwapiWarriorByID warrior = restTemplate.getForObject(
                    "https://swapi.dev/api/people/1/", SwapiWarriorByID.class);
            log.info(warrior.toString());
        };
    }



}
