package nutricao.planoAlimentar.Repository;

import nutricao.planoAlimentar.Model.Refeicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RefeicaoRepository extends JpaRepository<Refeicao, UUID> {

    //    @Query("select * from Refeicao ")
    //    public List<Refeicao> Listref(){return }
}
