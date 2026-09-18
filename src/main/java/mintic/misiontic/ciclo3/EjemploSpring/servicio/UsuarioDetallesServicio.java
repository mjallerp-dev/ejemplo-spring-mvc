package mintic.misiontic.ciclo3.EjemploSpring.servicio;

import mintic.misiontic.ciclo3.EjemploSpring.dao.IUsuarioCrud;
import mintic.misiontic.ciclo3.EjemploSpring.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetallesServicio implements UserDetailsService {

    @Autowired
    IUsuarioCrud crudUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = crudUser.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return User.withUsername(usuario.getCedula())
                .password("{noop}" + usuario.getClave())
                .roles("USER")
                .build();
    }
}
