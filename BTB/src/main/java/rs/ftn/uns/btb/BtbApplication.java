package rs.ftn.uns.btb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BtbApplication {

	@Autowired
	private Environment env;
	public static void main(String[] args) {
		SpringApplication.run(BtbApplication.class, args);
	}

	@Autowired
	public void LinkOpenAPI() {
		System.out.println("Link za OpenAPI UI: http://localhost:" + env.getProperty("server.port") + "/swagger-ui/index.html#/");
		System.out.println("Link za Client Server [Front]: http://localhost:" + env.getProperty("front.port") + "/");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

}
