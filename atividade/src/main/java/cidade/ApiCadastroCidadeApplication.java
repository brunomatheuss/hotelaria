package cidade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"endereco", "pessoa", "cidade", "estado"})
public class ApiCadastroCidadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCadastroCidadeApplication.class, args);
	}

}