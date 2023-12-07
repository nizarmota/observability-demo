package dev.nizar.observabilitydemo;

import dev.nizar.observabilitydemo.post.JsonPlaceholderService;
import io.micrometer.observation.annotation.Observed;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class ObservabilityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObservabilityDemoApplication.class, args);
    }

    @Bean
    JsonPlaceholderService jsonPlaceholderService() {
        RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com");
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
        return factory.createClient(JsonPlaceholderService.class);
    }


//    @Bean
//    @Observed(name = "posts.load-all-posts", contextualName = "post.find-all")
//    CommandLineRunner commandLineRunner(JsonPlaceholderService jsonPlaceholderService) {
//        return args -> {
//            jsonPlaceholderService.findAll();
//        };
//    }
}
