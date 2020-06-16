package reservaProduto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;


@Entity
public class ReservaProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private int quantidade;
	private String data_hora;
	
	ReservaProduto(){}

	public ReservaProduto(int qtd, String data_hora) {
		this.quantidade = qtd;
		this.data_hora = data_hora;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getData_hora() {
		return data_hora;
	}

	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}
	
	
	
	
}