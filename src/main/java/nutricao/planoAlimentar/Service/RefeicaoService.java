package nutricao.planoAlimentar.Service;

import lombok.RequiredArgsConstructor;
import nutricao.planoAlimentar.DTO.RefeicaoDTO;
import nutricao.planoAlimentar.Model.Alimento;
import nutricao.planoAlimentar.Model.Nutricionista;
import nutricao.planoAlimentar.Model.Paciente;
import nutricao.planoAlimentar.Model.Refeicao;
import nutricao.planoAlimentar.Repository.AlimentoRepository;
import nutricao.planoAlimentar.Repository.NutricionistaRepository;
import nutricao.planoAlimentar.Repository.PacienteRepository;
import nutricao.planoAlimentar.Repository.RefeicaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

@RequiredArgsConstructor
public class RefeicaoService {

    private final AlimentoRepository alimentoRepository;
    private final RefeicaoRepository refeicaoRepository;
    private final PacienteRepository pacienteRepository;
    private final NutricionistaRepository nutricionistaRepository;


    public Refeicao modificaRefeicao(UUID id, RefeicaoDTO dto) {
        Refeicao refeicaoAlterada = new Refeicao();
        //BUSCA Alimento PELO ID
        Optional<Refeicao> RefeicaoOptional = refeicaoRepository.findById(id);
        Refeicao Refeicao = RefeicaoOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Paciente Inexistente"));

        if (!(Refeicao.getName().equals(dto.getName()) || Refeicao.getName().isEmpty())) {
            refeicaoAlterada.setName(dto.getName());
        } else {
            refeicaoAlterada.setName(Refeicao.getName());
        }
        if (!Refeicao.getHora().equals(dto.getHora())) {
            refeicaoAlterada.setHora(dto.getHora());
        } else {
            refeicaoAlterada.setHora(Refeicao.getHora());
        }
        if (!Refeicao.getTurno().equals(dto.getTurno()) || Refeicao.getName().isEmpty()) {
            refeicaoAlterada.setTurno(dto.getTurno());
        } else {
            refeicaoAlterada.setTurno(Refeicao.getTurno());
        }

        List<Alimento> alimentoList = new ArrayList<Alimento>();

        for (int i = 0; i < dto.getAlimentos_ID().length; i++) {


            UUID alimentoID = dto.getAlimentos_ID()[i];

            Optional<Alimento> AlimentosOptional = alimentoRepository.findById(alimentoID);
            Alimento alimento = AlimentosOptional.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Alimento Inexistente"));
            alimentoList.add(alimento);
        }
        refeicaoAlterada.setAlimentos(alimentoList);

        //        BUSCA PACIENTE PELO ID
        Optional<Paciente> PacienteOptional = pacienteRepository.findById(dto.getId_paciente());
        Paciente paciente = PacienteOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Paciente Inexistente"));

        //BUSCA Nutricionista POR ID
        Optional<Nutricionista> NutricionistaOptional = nutricionistaRepository.findById(dto.getId_nutricionista());
        Nutricionista nutricionista = NutricionistaOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Nutricionista Inexistente"));

        refeicaoAlterada.setNutri(nutricionista);
        refeicaoAlterada.setId(id);
        refeicaoAlterada.setPaciente(paciente);


        return refeicaoRepository.save(refeicaoAlterada);

    }

    public Refeicao saveRefeicao(RefeicaoDTO DTO) {
        Refeicao newRef = new Refeicao();
        List<Alimento> alimentoList = new ArrayList<Alimento>();

        for (int i = 0; i < DTO.getAlimentos_ID().length; i++) {
            UUID alimentoID = DTO.getAlimentos_ID()[i];
            Optional<Alimento> AlimentosOptional = alimentoRepository.findById(alimentoID);
            Alimento alimento = AlimentosOptional.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Alimento Inexistente"));
            alimentoList.add(alimento);
        }

        newRef.setAlimentos(alimentoList);

//        BUSCA PACIENTE PELO ID
        Optional<Paciente> PacienteOptional = pacienteRepository.findById(DTO.getId_paciente());
        Paciente paciente = PacienteOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Paciente Inexistente"));

        //BUSCA Nutricionista POR ID
        Optional<Nutricionista> NutricionistaOptional = nutricionistaRepository.findById(DTO.getId_nutricionista());
        Nutricionista nutricionista = NutricionistaOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Nutricionista Inexistente"));

        newRef.setHora(DTO.getHora());
        newRef.setNutri(nutricionista);
        newRef.setPaciente(paciente);
        newRef.setTurno(DTO.getTurno());
        newRef.setName(DTO.getName());
        newRef.setId(UUID.randomUUID());

        return refeicaoRepository.save(newRef);
    }

//    public PlanoAlimentar SavePlanoAlimentar(PlanoAlimentarDTO DTO) {

}
