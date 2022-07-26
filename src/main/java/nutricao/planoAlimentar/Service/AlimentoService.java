package nutricao.planoAlimentar.Service;

import lombok.RequiredArgsConstructor;
import nutricao.planoAlimentar.DTO.AlimentoDTO;
import nutricao.planoAlimentar.Model.Alimento;
import nutricao.planoAlimentar.Repository.AlimentoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service

@RequiredArgsConstructor
public class AlimentoService {

    private final AlimentoRepository alimentoRepository;


    public Alimento modificaAlimento(UUID id, AlimentoDTO dto) {
        Alimento alimentoAlterado = new Alimento();

        //BUSCA Alimento PELO ID
        Optional<Alimento> AlimentoOptional = alimentoRepository.findById(id);
        Alimento alimento = AlimentoOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Paciente Inexistente"));
        if (!alimento.getName().equals(dto.getName())) {
            alimentoAlterado.setName(dto.getName());
        } else {
            alimentoAlterado.setName(alimento.getName());
        }
        if (alimento.getCarboidratos() != dto.getCarboidratos()) {
            alimentoAlterado.setCarboidratos(dto.getCarboidratos());
        } else {
            alimentoAlterado.setCarboidratos(alimento.getCarboidratos());
        }
        if (alimento.getProteina() != dto.getProteina()) {
            alimentoAlterado.setProteina(dto.getProteina());
        } else {
            alimentoAlterado.setProteina(alimento.getProteina());
        }
        if (alimento.getKAL() != dto.getKAL()) {
            alimentoAlterado.setKAL(dto.getKAL());
        } else {
            alimentoAlterado.setKAL(alimento.getKAL());
        }
        if (alimento.getGordura() != dto.getGordura()) {
            alimentoAlterado.setGordura(dto.getGordura());
        } else {
            alimentoAlterado.setName(alimento.getName());
        }
        alimentoAlterado.setId(alimento.getId());
        return alimentoRepository.save(alimentoAlterado);

    }


}
