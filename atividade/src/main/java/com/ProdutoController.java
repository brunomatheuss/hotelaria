package com;

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
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRespository;
	
	@PostMapping(value="/produto")
	public void inserirProduto(@RequestBody Produto produto)
	{
		this.produtoRespository.save(produto);
	}

	@GetMapping(value="/produto")
	public List<Produto> pegarProdutos()
	{
		return (List<Produto>) this.produtoRespository.findAll();
	}
	
	@PutMapping(value="/produto")
	public void alterarProduto(@RequestBody Produto produto)
	{
		// enviar o id
		this.produtoRespository.save(produto);
		
	}

	@GetMapping(value="/produto/{id}")
	public Produto pegarProduto(@PathVariable("id") int id) 
	{
		return this.produtoRespository.findById(id);
	}
	
	@DeleteMapping(value="/produto/{id}")
	public void excluirProduto(@PathVariable("id") int id)
	{
		this.produtoRespository.deleteById(id);
	}
}
