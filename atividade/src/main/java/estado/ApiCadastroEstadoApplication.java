package estado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"endereco", "pessoa", "cidade", "estado"})
public class ApiCadastroEstadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCadastroEstadoApplication.class, args);
	}

}