package mintic.misiontic.ciclo3.EjemploSpring;

import lombok.extern.slf4j.Slf4j;
import mintic.misiontic.ciclo3.EjemploSpring.modelo.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {

    @Value("${index.mensaje}")
    String dato;
    @GetMapping("/")
    public String inicio(Model modelo) {
        String mensaje = "Saludos desde Spring MVC";
        modelo.addAttribute("mensaje", mensaje);
        modelo.addAttribute("dato", dato);
        Usuario u = new Usuario();
        u.setCedula("1234");
        u.setClave("Abcd");
        u.setNombre("MIGUEL ANGEL JALLER PIÑERES");
        u.setEmail("mjallerp@unicartagena.edu.co");
        modelo.addAttribute("alguien", u);
        Usuario u2 = new Usuario();
        u2.setCedula("5678");
        u2.setClave("Efgh");
        u2.setNombre("YULEIDYS TORREGLOSA DIAZ");
        u2.setEmail("ydiaz@unicartagena.edu.co");
        Usuario u3 = new Usuario();
        u3.setCedula("4321");
        u3.setClave("xyz");
        u3.setNombre("JHON CARLOS ARRIETA ARRIETA ");
        u3.setEmail("jarrieta@unicartagena.edu.co");
        List<Usuario> listaUsuarios = Arrays.asList(u2, u3);
        modelo.addAttribute("usuarios", listaUsuarios);
        log.info("Ejecutando el controlador Inicio MVC");
        return "index";
    }
}
