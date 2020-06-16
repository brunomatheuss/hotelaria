package quarto;

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
public class QuartoController {
	
	@Autowired
	QuartoRepository quartoRespository;
	
	@PostMapping(value="/quarto")
	public void inserirQuarto(@RequestBody Quarto quarto)
	{
		this.quartoRespository.save(quarto);
	}

	@GetMapping(value="/quarto")
	public List<Quarto> pegarQuartos()
	{
		return (List<Quarto>) this.quartoRespository.findAll();
	}
	
	@PutMapping(value="/quarto")
	public void alterarQuarto(@RequestBody Quarto quarto)
	{
		this.quartoRespository.save(quarto);
		
	}

	@GetMapping(value="/quarto/{id}")
	public Quarto pegarQuarto(@PathVariable("id") int id) 
	{
		return this.quartoRespository.findById(id);
	}
	
	@DeleteMapping(value="/quarto/{id}")
	public void excluirQuarto(@PathVariable("id") int id)
	{
		this.quartoRespository.deleteById(id);
	}
}
