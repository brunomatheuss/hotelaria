package reserva;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Integer> {

	Reserva findById(int id);
	
	@Query("SELECT * FROM reserva WHERE pessoa_id = :idp and status_pagameno = 0")
	Reserva findQuartoReservado(@Param("idp") int quarto_id);
}
