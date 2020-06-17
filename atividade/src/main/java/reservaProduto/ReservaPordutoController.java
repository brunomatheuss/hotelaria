package reservaProduto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import produto.ProdutoRepository;
import reserva.ReservaRepository;


@RestController
public class ReservaPordutoController {
	
	@Autowired
	ReservaProdutoRepository reservaProdutoRespository;

	@Autowired
	ProdutoRepository produtoRespository;
	
	@Autowired
	ReservaRepository reservaRespository;
	
	@PostMapping(value="/reserva/quarto/{id}/produto/{idp}")
	public void inserirReservaProduto(@RequestBody ReservaProduto reservaProduto, @PathVariable("id") int id, @PathVariable("idp") int idp)
	{
		reservaProduto.setReserva(this.reservaRespository.findById(id));
		reservaProduto.setProduto(this.produtoRespository.findById(idp));
		this.reservaProdutoRespository.save(reservaProduto);
	}

	@GetMapping(value="/reserva/produto")
	public List<ReservaProduto> pegarReservaProduto()
	{
		return (List<ReservaProduto>) this.reservaProdutoRespository.findAll();
	}
	
	@PutMapping(value="/reserva/quarto/{id}/produto/{idp}")
	public void alterarPagamento(@RequestBody ReservaProduto reservaProduto, @PathVariable("id") int id, @PathVariable("idp") int idp)
	{
		reservaProduto.setReserva(this.reservaRespository.findById(id));
		reservaProduto.setProduto(this.produtoRespository.findById(idp));
		this.reservaProdutoRespository.save(reservaProduto);
		
	}

	@GetMapping(value="/reserva/produto/{id}")
	public ReservaProduto pegarReservaProduto(@PathVariable("id") int id) 
	{
		return this.reservaProdutoRespository.findById(id);
	}
	
	@DeleteMapping(value="/reserva/produto/{id}")
	public void excluirReservaProduto(@PathVariable("id") int id)
	{
		this.reservaProdutoRespository.deleteById(id);
	}
}
