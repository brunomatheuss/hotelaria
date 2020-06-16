package reserva;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;

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
	
	
	public Reserva() {}
	
	public Reserva(int id, Date dataEntrada, Date dataSaida, double valorFinal, int statusPagameno) {
		super();
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
	
	
	
	
}
