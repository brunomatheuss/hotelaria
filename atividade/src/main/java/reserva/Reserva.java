package reserva;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;

import pessoa.Pessoa;
import quarto.Quarto;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private int id;
	private Date dataEntrada;
	private Date dataSaida;
	private double valorFinal;
	private int statusPagameno;
	
	@ManyToOne
	@JoinColumn(name = "quarto_id")
	private Quarto quarto;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	public Reserva() {}
	
	public Reserva(int id, Date dataEntrada, Date dataSaida, double valorFinal, int statusPagameno) {
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valorFinal = valorFinal;
		this.statusPagameno = statusPagameno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public int getStatusPagameno() {
		return statusPagameno;
	}

	public void setStatusPagameno(int statusPagameno) {
		this.statusPagameno = statusPagameno;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
		this.quarto.setDisponivel(1);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
}
