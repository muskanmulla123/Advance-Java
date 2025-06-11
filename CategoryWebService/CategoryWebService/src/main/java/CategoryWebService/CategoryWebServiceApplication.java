package CategoryWebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CategoryWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryWebServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		System.out.println("resttempalte created");
		return new RestTemplate();
	}

}
