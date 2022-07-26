package nutricao.planoAlimentar.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class AlimentoDTO {
    private UUID id;
    private String name;
    private Integer KAL;
    private Integer proteina;
    private Integer carboidratos;
    private Integer gordura;
}
