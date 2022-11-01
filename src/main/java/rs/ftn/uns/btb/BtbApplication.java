package rs.ftn.uns.btb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BtbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtbApplication.class, args);
		System.out.println("Link za OpenAPI UI: http://localhost:8080/swagger-ui/index.html#/");
	}

}
