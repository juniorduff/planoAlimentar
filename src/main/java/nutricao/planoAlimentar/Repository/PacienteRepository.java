package nutricao.planoAlimentar.Repository;

import nutricao.planoAlimentar.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
}
