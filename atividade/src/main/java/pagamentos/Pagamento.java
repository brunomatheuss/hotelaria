package pagamentos;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;

import reserva.Reserva;


@Entity
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private int id;
	private int numParcelas;
	private int parcela;
	private int status;
	private double valor;
	private Date dataPagamento;
	
	@ManyToOne
	@JoinColumn(name = "reserva_id")
	private Reserva reserva;
	
	Pagamento(){}

	public Pagamento(int id, int numParcelas, int parcela, int status, double valor, Date dataPagamento) {
		this.id = id;
		this.numParcelas = numParcelas;
		this.parcela = parcela;
		this.status = status;
		this.valor = valor;
		this.dataPagamento = dataPagamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumParcelas() {
		return numParcelas;
	}

	public void setNumParcelas(int numParcelas) {
		this.numParcelas = numParcelas;
	}

	public int getParcela() {
		return parcela;
	}

	public void setParcela(int parcela) {
		this.parcela = parcela;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	
	
	
	
	
	
}