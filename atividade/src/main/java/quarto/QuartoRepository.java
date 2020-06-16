package quarto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends CrudRepository<Quarto, Integer> {
	
	Quarto findById(int id);

}
