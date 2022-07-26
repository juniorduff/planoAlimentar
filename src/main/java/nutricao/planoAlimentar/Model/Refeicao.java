package nutricao.planoAlimentar.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Refeicao {


    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false, length = 150)
    private String turno;
    @OneToOne
    private Paciente paciente;
    @OneToOne
    private Nutricionista nutri;
    @Column(nullable = false, length = 150)
    private String hora;
    @ManyToMany()
    @JsonIgnore
    private List<Alimento> alimentos = new ArrayList<Alimento>();


}
