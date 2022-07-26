package nutricao.planoAlimentar.Repository;

import nutricao.planoAlimentar.Model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlimentoRepository extends JpaRepository<Alimento, UUID> {




}
