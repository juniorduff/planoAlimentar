package nutricao.planoAlimentar.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Alimento {


    @ManyToMany(mappedBy = "alimentos")
    List<Refeicao> refeicoes = new ArrayList<Refeicao>();
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column
    private String name;
    @Column
    private Integer KAL;
    @Column
    private Integer proteina;
    @Column
    private Integer carboidratos;
    @Column
    private Integer gordura;

}
