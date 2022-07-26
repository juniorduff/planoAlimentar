package nutricao.planoAlimentar.Service;

import lombok.RequiredArgsConstructor;
import nutricao.planoAlimentar.DTO.NutricionistaDTO;
import nutricao.planoAlimentar.Model.Nutricionista;
import nutricao.planoAlimentar.Repository.NutricionistaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service

@RequiredArgsConstructor
public class NutricionistaService {

    private final NutricionistaRepository nutricionistaRepository;


    public Nutricionista modificaNutrista(UUID id, NutricionistaDTO dto) {
        Nutricionista nutricionistaAlterado = new Nutricionista();

        Optional<Nutricionista> NutricionistaOptional = nutricionistaRepository.findById(id);
        Nutricionista nutricionista = NutricionistaOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Nutricionista Inexistente"));

        if (!nutricionista.getCpf().equals(dto.getCpf())) {
            nutricionistaAlterado.setCpf(dto.getCpf());

        } else {
            nutricionistaAlterado.setCpf(nutricionista.getCpf());

        }
        if (!nutricionista.getEmail().equals(dto.getEmail())) {
            nutricionistaAlterado.setEmail(dto.getEmail());
        } else {
            nutricionistaAlterado.setCpf(nutricionista.getCpf());
        }
        if (!nutricionista.getNome().equals(dto.getNome())) {
            nutricionistaAlterado.setNome(dto.getNome());
        } else {
            nutricionistaAlterado.setNome(nutricionista.getNome());
        }
        if (!nutricionista.getPassword().equals(dto.getPassword())) {
            nutricionistaAlterado.setPassword(dto.getPassword());

        } else {
            nutricionistaAlterado.setPassword(nutricionista.getPassword());
        }
        nutricionistaAlterado.setUpdatedAt(LocalDate.now());
        nutricionistaAlterado.setId(nutricionista.getId());

        return nutricionistaRepository.save(nutricionistaAlterado);
    }
}
