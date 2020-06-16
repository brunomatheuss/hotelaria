package pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import endereco.EnderecoRepository;


@RestController
public class PessoaController {
	
	@Autowired
	PessoaRepository pessoaRespository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@PostMapping(value="/pessoa/{id}")
	public void inserirPessoa(@RequestBody Pessoa pessoa, @PathVariable("id") int id)
	{
		pessoa.setEndereco(this.enderecoRepository.findById(id));
		this.pessoaRespository.save(pessoa);
	}

	@GetMapping(value="/pessoa")
	public List<Pessoa> pegarPessoas()
	{
		return (List<Pessoa>) this.pessoaRespository.findAll();
	}
	
	@PutMapping(value="/pessoa")
	public void alterarPessoa(@RequestBody Pessoa pessoa)
	{
		this.pessoaRespository.save(pessoa);
		
	}

	@GetMapping(value="/pessoa/{cpf}")
	public Pessoa pegarPessoa(@PathVariable("cpf") int cpf) 
	{
		return this.pessoaRespository.findById(cpf);
	}
	
	@DeleteMapping(value="/pessoa/{cpf}")
	public void excluirPessoa(@PathVariable("cpf") int cpf)
	{
		this.pessoaRespository.deleteById(cpf);
	}
}
