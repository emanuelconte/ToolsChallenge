package repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, String> {

}