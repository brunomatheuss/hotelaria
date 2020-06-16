package estado;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cidade.Cidade;
import cidade.CidadeRepository;

@RestController
public class EstadoController {
	
	@Autowired
	EstadoRepository estadoRespository;
	
	@Autowired
	CidadeRepository cidadeRespository;
	
	@PostMapping(value="/estado")
	public void inserirEstado(@RequestBody Estado estado)
	{
		this.estadoRespository.save(estado);
	}

	@GetMapping(value="/estado")
	public List<Estado> pegarEstado()
	{
		return (List<Estado>) this.estadoRespository.findAll();
	}
	
	@PutMapping(value="/estado")
	public void alterarEstado(@RequestBody Estado estado)
	{
		// enviar o id
		this.estadoRespository.save(estado);
		
	}

	@GetMapping(value="/estado/{id}")
	public Estado pegarEstado(@PathVariable("id") int id) 
	{
		return this.estadoRespository.findById(id);
	}
	
	@DeleteMapping(value="/estado/{id}")
	public void excluirEstado(@PathVariable("id") int id)
	{
		this.estadoRespository.deleteById(id);
	}
	
	@GetMapping(value="/estado/{id}/cidades")
	public List<Cidade> pegarCidades(@PathVariable("id") int id)
	{
		return (List<Cidade>) this.estadoRespository.findById(id).getCidades();
	}
}
