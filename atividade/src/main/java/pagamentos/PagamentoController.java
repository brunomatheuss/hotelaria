package pagamentos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reserva.ReservaRepository;


@RestController
public class PagamentoController {
	
	@Autowired
	PagamentoRepository pagamentoRespository;
	
	@Autowired
	ReservaRepository reservaRepository;
	
	@PostMapping(value="/pagamento/reserva/{id}")
	public void inserirPagamento(@RequestBody Pagamento pagamento, @PathVariable("id") int id)
	{
		pagamento.setReserva(this.reservaRepository.findById(id));
		this.pagamentoRespository.save(pagamento);
	}

	@GetMapping(value="/pagamento")
	public List<Pagamento> pegarPagamentos()
	{
		return (List<Pagamento>) this.pagamentoRespository.findAll();
	}
	
	@PutMapping(value="/pagamento")
	public void alterarPagamento(@RequestBody Pagamento pagamento, @PathVariable("id") int id)
	{
		pagamento.setReserva(this.reservaRepository.findById(id));
		this.pagamentoRespository.save(pagamento);
		
	}

	@GetMapping(value="/pagamento/{id}")
	public Pagamento pegarPagamento(@PathVariable("id") int id) 
	{
		return this.pagamentoRespository.findById(id);
	}
	
	@DeleteMapping(value="/pagamento/{id}")
	public void excluirPagamento(@PathVariable("id") int id)
	{
		this.pagamentoRespository.deleteById(id);
	}
}
