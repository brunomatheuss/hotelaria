package cidade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CidadeController {
	
	@Autowired
	CidadeRepository cidadeRespository;
	
	@Autowired
	EstadoRepository estadoRespository;
	
	@PostMapping(value="/cidade/{id}")
	public void inserirCidade(@RequestBody Cidade cidade, @PathVariable("id") int id)
	{
		cidade.setEstado(this.estadoRespository.findById(id));
		this.cidadeRespository.save(cidade);
	}

	@GetMapping(value="/cidade")
	public List<Cidade> pegarCidades()
	{
		return (List<Cidade>) this.cidadeRespository.findAll();
	}
	
	@PutMapping(value="/cidade")
	public void alterarCidade(@RequestBody Cidade cidade)
	{
		// enviar o id
		this.cidadeRespository.save(cidade);
		
	}

	@GetMapping(value="/cidade/{id}")
	public Cidade pegarCidade(@PathVariable("id") int id) 
	{
		return this.cidadeRespository.findById(id);
	}
	
	@DeleteMapping(value="/cidade/{id}")
	public void excluirCidade(@PathVariable("id") int id)
	{
		this.cidadeRespository.deleteById(id);
	}
}
