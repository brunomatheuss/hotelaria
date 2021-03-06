package cidade;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, Integer> {
	
	Cidade findById(int id);
	
	List<Cidade> findByEstadoId(int id);

}