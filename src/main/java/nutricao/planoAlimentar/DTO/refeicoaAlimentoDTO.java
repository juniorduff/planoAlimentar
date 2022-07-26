package nutricao.planoAlimentar.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor

public class refeicoaAlimentoDTO {
    private UUID refeiecao_id;
    private UUID Alimento_id;


}
