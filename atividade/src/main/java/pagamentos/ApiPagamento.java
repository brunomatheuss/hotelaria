package pagamentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"cidade", "endereco", "estado", "pagamentos", "pessoa", "produto", "quarto", "reserva", "reservaProduto"})
public class ApiPagamento {

	public static void main(String[] args) {
		SpringApplication.run(ApiPagamento.class, args);
	}

}