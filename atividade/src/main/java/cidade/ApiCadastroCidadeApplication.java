package cidade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"caixa","cidade", "endereco", "estado", "pagamentos", "pessoa", "produto", "quarto", "reserva", "reservaProduto"})
public class ApiCadastroCidadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCadastroCidadeApplication.class, args);
	}

}