package nutricao.planoAlimentar.Controller;

import lombok.RequiredArgsConstructor;
import nutricao.planoAlimentar.DTO.AlimentoDTO;
import nutricao.planoAlimentar.Model.Alimento;
import nutricao.planoAlimentar.Repository.AlimentoRepository;
import nutricao.planoAlimentar.Service.AlimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/app/alimento")
@CrossOrigin("http://localhost:4200")
public class AlimentoController {
    private final AlimentoRepository alimentoRepository;
    private final AlimentoService alimentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Alimento saveAlimento(@RequestBody Alimento alimento) {
        return alimentoRepository.save(alimento);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlimento(@PathVariable UUID id) {
        alimentoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Alimento ModificaAlimento(@PathVariable UUID id, @RequestBody AlimentoDTO alimentodto) {
        return alimentoService.modificaAlimento(id, alimentodto);
    }
    @GetMapping
    public List<Alimento> listAlimentos() {
        return alimentoRepository.findAll();
    }
}
