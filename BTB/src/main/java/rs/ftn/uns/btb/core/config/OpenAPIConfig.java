package rs.ftn.uns.btb.core.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenAPIConfig {

    @Autowired
    private Environment env;
    @Bean
    public OpenAPI openApi() {
        ArrayList<Server> servers = new ArrayList<>(3);
        String PORT = env.getProperty("server.port");
        servers.add(new Server().url("http://localhost:" + PORT +"/").description("development server"));
        servers.add(new Server().url("http://link-do-test-servera:8081").description("test server"));
        servers.add(new Server().url("http://link-do-sajta-za-app.com/").description("production server"));

        final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
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
