package repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Estorno;

@Repository
public interface EstornoRepository extends JpaRepository<Estorno, String> {

}