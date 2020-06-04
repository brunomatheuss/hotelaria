package cidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;

@Entity
public class Cidade {

	@Id
	@GeneratedValue
	@OrderBy
	private int id;
	private String nome;
	

	@ManyToOne
	private Estado estado;
	
	Cidade(){}
	
	Cidade(int id, String nome)
	{
		this.id = id;
		this.nome = nome;
	}	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
		this.estado.getCidades().add(this);
	}

	
	
	
	
}
