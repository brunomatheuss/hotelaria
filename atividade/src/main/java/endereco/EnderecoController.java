package endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cidade.CidadeRepository;
import pessoa.PessoaRepository;


@RestController
public class EnderecoController {
	
	@Autowired
	EnderecoRepository enderecoRespository;
	
	@Autowired
	PessoaRepository pessoaRespository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@PostMapping(value="/endereco/{id}")
	public Endereco inserirEndereco(@RequestBody Endereco endereco, @PathVariable("id") int id)
	{
		endereco.setCidade(this.cidadeRepository.findById(id));
		this.enderecoRespository.save(endereco);
		return endereco;
	}

	@GetMapping(value="/endereco")
	public List<Endereco> pegarEnderecos()
	{
		return (List<Endereco>) this.enderecoRespository.findAll();
	}
	
	@PutMapping(value="/endereco")
	public void alterarEndereco(@RequestBody Endereco endereco)
	{
		this.enderecoRespository.save(endereco);
		
	}

	@GetMapping(value="/endereco/{id}")
	public Endereco pegarEndereco(@PathVariable("id") int id) 
	{
		return this.enderecoRespository.findById(id);
	}
	
	@DeleteMapping(value="/endereco/{id}")
	public void excluirEndereco(@PathVariable("id") int id)
	{
		this.enderecoRespository.deleteById(id);
	}
}
