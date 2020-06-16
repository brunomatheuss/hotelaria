package pessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"endereco", "pessoa", "cidade", "estado"})
public class ApiPessoa {

	public static void main(String[] args) {
		SpringApplication.run(ApiPessoa.class, args);
	}

}