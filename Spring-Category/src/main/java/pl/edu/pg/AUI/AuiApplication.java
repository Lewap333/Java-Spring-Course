package pl.edu.pg.AUI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
@SpringBootApplication
public class AuiApplication {

	public static void main(String[] args) {

		SpringApplication.run(AuiApplication.class, args);

	}

	// Calls http://localhost:8081
	@Bean
	public RestTemplate restTemplate(@Value("${aui.product.url}") String baseUrl) {
		return new RestTemplateBuilder()
				.rootUri(baseUrl)
				.build();
	}
}
