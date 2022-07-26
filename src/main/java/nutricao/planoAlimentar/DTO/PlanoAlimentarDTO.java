package nutricao.planoAlimentar.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class PlanoAlimentarDTO {
    //DADOS DA REFEICAO
    private String periodo;
    private String nomeRefeicao;
    private String turnoRefeicao;
    private String horaRefeicao;
    private UUID [] id_alimentos;



    private RefeicaoDTO refeicaoDTO;
    private UUID id_nutricionista;
    private UUID id_paciente;
    private String createdAt;
    private long totalCalorico;
}
