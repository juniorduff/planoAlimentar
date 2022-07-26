package nutricao.planoAlimentar.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class NutricionistaDTO {
    public String id;
    public String nome;
    public String cpf;
    public String email;
    public String password;

}
