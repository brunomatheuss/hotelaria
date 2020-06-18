package reservaProduto;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaProdutoRepository extends CrudRepository<ReservaProduto, Integer> {
	
	List<ReservaProduto> findByReservaId(int id);
	}
