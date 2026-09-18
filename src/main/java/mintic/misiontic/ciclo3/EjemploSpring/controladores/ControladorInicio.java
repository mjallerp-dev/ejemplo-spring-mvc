package mintic.misiontic.ciclo3.EjemploSpring.controladores;

import lombok.extern.slf4j.Slf4j;
import mintic.misiontic.ciclo3.EjemploSpring.dao.IUsuarioCrud;
import mintic.misiontic.ciclo3.EjemploSpring.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    IUsuarioCrud crudUsuario;
    @GetMapping("/")
    public String inicio(Model modelo) {
        List<Usuario> listaUsuarios = (List<Usuario>) crudUsuario.findAll();
        modelo.addAttribute("usuarios", listaUsuarios);
        log.info("Ejecutando el controlador Inicio MVC");
        return "index";
    }
}
