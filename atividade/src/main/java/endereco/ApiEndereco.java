package endereco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"endereco", "pessoa", "cidade", "estado"})
public class ApiEndereco {

	public static void main(String[] args) {
		SpringApplication.run(ApiEndereco.class, args);
	}

}