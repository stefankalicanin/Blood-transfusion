package rs.ftn.uns.btb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

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

}
