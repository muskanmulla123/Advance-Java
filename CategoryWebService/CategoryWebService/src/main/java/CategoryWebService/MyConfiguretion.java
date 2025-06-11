package CategoryWebService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//@Configuration
public class MyConfiguretion {
	//@Bean
	public RestTemplate getRestTemplate() {
		System.out.println("resttempalte created");
		return new RestTemplate();
	}
}
