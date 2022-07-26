package nutricao.planoAlimentar.Controller;

import lombok.RequiredArgsConstructor;
import nutricao.planoAlimentar.DTO.NutricionistaDTO;
import nutricao.planoAlimentar.DTO.RefeicaoDTO;
import nutricao.planoAlimentar.Model.Nutricionista;
import nutricao.planoAlimentar.Model.Refeicao;
import nutricao.planoAlimentar.Repository.NutricionistaRepository;
import nutricao.planoAlimentar.Service.NutricionistaService;
import nutricao.planoAlimentar.Service.RefeicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/app/nutricionista")
public class NutricionistaController {
    private final NutricionistaRepository nutricionistaRepository;
    private final RefeicaoService RefeicaoService;
    private final NutricionistaService nutricionistaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Nutricionista save(@RequestBody Nutricionista nutricionista) {
        return nutricionistaRepository.save(nutricionista);
    }

    @PutMapping("{id}")
    public Nutricionista modificaRefeicao(@PathVariable UUID id, @RequestBody NutricionistaDTO dto) {
        return nutricionistaService.modificaNutrista(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        nutricionistaRepository.deleteById(id);
    }

    @GetMapping
    public List<Nutricionista> listNutricionista() {
        return nutricionistaRepository.findAll();
    }
}
