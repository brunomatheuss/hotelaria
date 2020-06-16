package reserva;

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
public class ReservaController {
	
	@Autowired
	ReservaRepository reservaRespository;
	
	@PostMapping(value="/reserva")
	public void inserirReserva(@RequestBody Reserva reserva)
	{
		this.reservaRespository.save(reserva);
	}

	@GetMapping(value="/reserva")
	public List<Reserva> pegarReservas()
	{
		return (List<Reserva>) this.reservaRespository.findAll();
	}
	
	@PutMapping(value="/reserva")
	public void alterarReserva(@RequestBody Reserva reserva)
	{
		this.reservaRespository.save(reserva);
		
	}

	@GetMapping(value="/reserva/{id}")
	public Reserva pegarReserva(@PathVariable("id") int id) 
	{
		return this.reservaRespository.findById(id);
	}
	
	@DeleteMapping(value="/reserva/{id}")
	public void excluirReserva(@PathVariable("id") int id)
	{
		this.reservaRespository.deleteById(id);
	}
}
