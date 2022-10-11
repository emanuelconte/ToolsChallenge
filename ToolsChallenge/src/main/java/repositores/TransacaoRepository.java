package repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String>{

}
