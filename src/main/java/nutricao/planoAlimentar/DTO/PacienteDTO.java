package nutricao.planoAlimentar.DTO;

import lombok.Data;

@Data
public class PacienteDTO {
    public String id;
    public String nome;
    public String cpf;
    public String objetivo;
    public double peso;
    public double altura;
    public String email;
    public String password;
    public Object createdAt;
    public Object updatedAt;
}
