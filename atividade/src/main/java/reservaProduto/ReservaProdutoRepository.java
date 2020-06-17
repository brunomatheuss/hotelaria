package reservaProduto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaProdutoRepository extends CrudRepository<ReservaProduto, Integer> {
	
	ReservaProduto findById(int id);
}
