package cidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Estado {

	@Id
	@GeneratedValue
	@OrderBy
	private int id;
	private String nome;
	
	@JsonIgnore
	@OneToMany
	private List<Cidade> cidades;
		
	Estado(){}
	
	Estado(int id, String nome)
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

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	
	
	
}
