package reservaProduto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;

import produto.Produto;
import reserva.Reserva;


@Entity
public class ReservaProduto {
	
	@Id
	@OrderBy
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantidade;
	private String data_hora;
	
	@ManyToOne
	@JoinColumn(name = "reserva_id")
	private Reserva reserva;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	
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

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}