package produto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"cidade", "endereco", "estado", "pagamentos", "pessoa", "produto", "quarto", "reserva", "reservaProduto"})
public class ApiCadastroProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCadastroProdutoApplication.class, args);
	}

}