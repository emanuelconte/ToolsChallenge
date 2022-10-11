package repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Descricao;

@Repository
public interface DescricaoRepository extends JpaRepository<Descricao, String> {

}
