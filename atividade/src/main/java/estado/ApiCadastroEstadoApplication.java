package estado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"cidade", "endereco", "estado", "pagamentos", "pessoa", "produto", "quarto", "reserva", "reservaProduto"})
public class ApiCadastroEstadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCadastroEstadoApplication.class, args);
	}

}