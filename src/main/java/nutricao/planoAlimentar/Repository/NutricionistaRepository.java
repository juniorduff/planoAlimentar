package nutricao.planoAlimentar.Repository;

import nutricao.planoAlimentar.Model.Nutricionista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NutricionistaRepository extends JpaRepository<Nutricionista, UUID> {


    Optional<Nutricionista> findBynome(String userName);
}
