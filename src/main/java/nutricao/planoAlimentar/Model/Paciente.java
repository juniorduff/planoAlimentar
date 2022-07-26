package nutricao.planoAlimentar.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Paciente implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(nullable = false, length = 150)
    private String nome;
    @Column(nullable = false, length = 150)
    private String cpf;
    @Column(unique = true, nullable = false)
    private String objetivo;
    @Column(nullable = false)
    private double peso;
    @Column(nullable = false)
    private double altura;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column
    private LocalDate createdAt;
    @Column
    private LocalDate updatedAt;
}
