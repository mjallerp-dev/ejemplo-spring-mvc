package mintic.misiontic.ciclo3.EjemploSpring.controladores;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mintic.misiontic.ciclo3.EjemploSpring.modelo.Usuario;
import mintic.misiontic.ciclo3.EjemploSpring.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    IUsuarioServicio userServicio;

    @GetMapping("/")
    public String inicio() {
        return "home";
    }

    @GetMapping("/usuarios")
    public String listar(Model modelo) {
        List<Usuario> listaUsuarios = (List<Usuario>) userServicio.listarUsuarios();
        modelo.addAttribute("usuarios", listaUsuarios);
        log.info("Ejecutando el controlador Inicio MVC");
        return "usuarios";
    }

    @GetMapping("/usuarios/agregar")
    public String agregar(Usuario usuario) {
        return "modificar";
    }

    @PostMapping("/usuarios/guardar")
    public String guardar(@Valid Usuario usuario, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        userServicio.guardar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{cedula}")
    public String editar(Usuario usuario, Model modelo) {
        log.info("Invocando el metodo editar");
        usuario = userServicio.buscar(usuario);
        modelo.addAttribute("usuario", usuario);
        return "modificar";
    }

    @GetMapping("/usuarios/eliminar/{cedula}")
    public String eliminar(Usuario usuario) {
        userServicio.eliminar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/buscarNombre")
    public String buscarPorNombre(@RequestParam String nombre, Model modelo) {
        modelo.addAttribute("usuarios", userServicio.buscarPorNombre(nombre));
        return "usuarios";
    }

    @GetMapping("/usuarios/buscarEmail")
    public String buscarPorEmail(@RequestParam String email, Model modelo) {
        modelo.addAttribute("usuarios", userServicio.buscarPorEmail(email));
        return "usuarios";
    }
}
