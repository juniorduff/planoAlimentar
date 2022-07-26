package nutricao.planoAlimentar.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class RefeicaoDTO {

    private String name;
    private String turno;
    private String hora;
    private UUID id_nutricionista;
    private UUID id_paciente;
    private UUID[] alimentos_ID;
    //private PlanoAlimentar planoAlimentar;
}

