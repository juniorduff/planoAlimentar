package nutricao.planoAlimentar.Service;

import nutricao.planoAlimentar.Model.Nutricionista;
import nutricao.planoAlimentar.Repository.NutricionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Nutricionista nutri = nutricionistaRepository.findBynome(username)
                .orElseThrow(() -> new UsernameNotFoundException("login nãao encontrado"));

        return User
                .builder()
                .username(nutri.getNome())
                .password(nutri.getPassword())
                .roles("NUTRICIONISTA")
                .build();
    }
}
