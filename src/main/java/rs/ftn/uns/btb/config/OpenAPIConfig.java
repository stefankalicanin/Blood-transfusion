package rs.ftn.uns.btb.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI openApi() {
        ArrayList<Server> servers = new ArrayList<>(3);
        servers.add(new Server().url("http://localhost:8080/").description("development server"));
        servers.add(new Server().url("http://qa:8081").description("test server"));
        servers.add(new Server().url("http://rest-example.com/").description("production server"));

        return new OpenAPI()
                .info(new Info()
                        .title("BTB - Blood Transfusion Bank")
                        .description("BTB OpenAPI docs")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("s-matke")
                                .url("https://github.com/s-matke")
                                .email("stefan.matkovic@hotmail.com"))
                        .termsOfService("TOC")
                        .license(new License().name("License").url("#"))
                )
                .servers(servers);
    }
}
