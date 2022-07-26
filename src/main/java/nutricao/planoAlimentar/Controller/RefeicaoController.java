package nutricao.planoAlimentar.Controller;

import lombok.RequiredArgsConstructor;
import nutricao.planoAlimentar.DTO.RefeicaoDTO;
import nutricao.planoAlimentar.Model.Refeicao;
import nutricao.planoAlimentar.Repository.AlimentoRepository;
import nutricao.planoAlimentar.Repository.RefeicaoRepository;
import nutricao.planoAlimentar.Service.RefeicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/app/refeicao")
@CrossOrigin("http://localhost:4200")
public class RefeicaoController {
    private final AlimentoRepository alimentoRepository;
    private final RefeicaoService refeicaoService;
    private final RefeicaoRepository refeicaoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Refeicao saveRefeicao(@RequestBody RefeicaoDTO DTO) {
        return refeicaoService.saveRefeicao(DTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlimento(@PathVariable UUID id) {
        refeicaoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Refeicao ModificaRefeicao(@PathVariable UUID id, @RequestBody RefeicaoDTO dto) {
        return refeicaoService.modificaRefeicao(id, dto);
    }
    @GetMapping
    public List<Refeicao> ListarRefeicoes() {
        return refeicaoRepository.findAll();
    }
}
