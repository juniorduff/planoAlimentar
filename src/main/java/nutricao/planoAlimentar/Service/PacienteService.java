package nutricao.planoAlimentar.Service;

import lombok.RequiredArgsConstructor;
import nutricao.planoAlimentar.DTO.PacienteDTO;
import nutricao.planoAlimentar.Model.Paciente;
import nutricao.planoAlimentar.Repository.PacienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service

@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;


    public Paciente modificarPaciente(UUID id, PacienteDTO dto) {
        Paciente pacienteAlterado = new Paciente();
        //BUSCA Alimento PELO ID
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        Paciente paciente = pacienteOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Paciente Inexistente"));


        if (!paciente.getNome().equals(dto.getNome())) {
            pacienteAlterado.setNome(dto.getNome());
        } else {
            pacienteAlterado.setNome(paciente.getNome());
        }
        if (paciente.getAltura() != dto.getAltura()) {
            pacienteAlterado.setAltura(dto.getAltura());
        } else {
            pacienteAlterado.setAltura(paciente.getAltura());
        }
        if (paciente.getPeso() != dto.getPeso()) {
            pacienteAlterado.setPeso(dto.getPeso());
        } else {
            pacienteAlterado.setPeso(paciente.getPeso());
        }
        if (!paciente.getCpf().equals(dto.getAltura())) {
            pacienteAlterado.setCpf(dto.getCpf());
        } else {
            pacienteAlterado.setCpf(paciente.getCpf());
        }
        if (!paciente.getEmail().equals(dto.getEmail())) {
            pacienteAlterado.setEmail(dto.getEmail());
        } else {
            pacienteAlterado.setEmail(paciente.getEmail());
        }
        if (!paciente.getObjetivo().equals(dto.getObjetivo())) {
            pacienteAlterado.setObjetivo(dto.getObjetivo());
        } else {
            pacienteAlterado.setObjetivo(paciente.getObjetivo());
        }
        if (!paciente.getPassword().equals(dto.getPassword())) {
            pacienteAlterado.setPassword(dto.getPassword());
        } else {
            pacienteAlterado.setPassword(paciente.getPassword());
        }
        if (paciente.getAltura() != dto.getAltura()) {
            pacienteAlterado.setAltura(dto.getAltura());
        } else {
            pacienteAlterado.setAltura(paciente.getAltura());

        }
        pacienteAlterado.setUpdatedAt(LocalDate.now());
        pacienteAlterado.setId(paciente.getId());


        return pacienteRepository.save(pacienteAlterado);

    }


}
