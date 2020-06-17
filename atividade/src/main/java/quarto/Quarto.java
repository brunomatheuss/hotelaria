package quarto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;


@Entity
public class Quarto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OrderBy
	private int numero;
	private int capacidade;
	private double diaria;
	private int disponivel;

	
	Quarto(){}

	public Quarto(int id, int numero, int capacidade, double diaria, int disponivel) {
		this.id = id;
		this.numero = numero;
		this.capacidade = capacidade;
		this.diaria = diaria;
		this.disponivel = disponivel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public double getDiaria() {
		return diaria;
	}

	public void setDiaria(double diaria) {
		this.diaria = diaria;
	}

	public int getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(int disponivel) {
		this.disponivel = disponivel;
	}

	
	
}