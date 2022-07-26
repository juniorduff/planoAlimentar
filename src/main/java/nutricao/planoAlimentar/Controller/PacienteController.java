package nutricao.planoAlimentar.Controller;

import lombok.RequiredArgsConstructor;
import nutricao.planoAlimentar.DTO.PacienteDTO;
import nutricao.planoAlimentar.Model.Paciente;
import nutricao.planoAlimentar.Model.Refeicao;
import nutricao.planoAlimentar.Repository.PacienteRepository;
import nutricao.planoAlimentar.Service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/app/paciente")
public class PacienteController {
    private final PacienteRepository pacienteRepository;
    private final PacienteService pacienteService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente SavePaciente(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        pacienteRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Paciente modificaPaciente(@PathVariable UUID id, @RequestBody PacienteDTO dto) {
        return pacienteService.modificarPaciente(id, dto);
    }


    @GetMapping
    public List<Paciente> listPacientes() {
        return pacienteRepository.findAll();
    }
}
