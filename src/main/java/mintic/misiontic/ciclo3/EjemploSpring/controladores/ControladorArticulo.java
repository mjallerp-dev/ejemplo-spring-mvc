package mintic.misiontic.ciclo3.EjemploSpring.controladores;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mintic.misiontic.ciclo3.EjemploSpring.modelo.Articulo;
import mintic.misiontic.ciclo3.EjemploSpring.servicio.IArticuloServicio;
import mintic.misiontic.ciclo3.EjemploSpring.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/articulos")
public class ControladorArticulo {

    @Autowired
    IArticuloServicio articuloServicio;

    @Autowired
    IUsuarioServicio usuarioServicio;

    @GetMapping
    public String listar(Model modelo) {
        modelo.addAttribute("articulos", articuloServicio.listarArticulos());
        log.info("Ejecutando el controlador Articulo MVC");
        return "articulos";
    }

    @GetMapping("/agregar")
    public String agregar(Articulo articulo, Model modelo) {
        modelo.addAttribute("usuarios", usuarioServicio.listarUsuarios());
        return "modificarArticulo";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Articulo articulo, Errors errores, Model modelo) {
        if (errores.hasErrors()) {
            modelo.addAttribute("usuarios", usuarioServicio.listarUsuarios());
            return "modificarArticulo";
        }
        articuloServicio.guardar(articulo);
        return "redirect:/articulos";
    }

    @GetMapping("/editar/{id}")
    public String editar(Articulo articulo, Model modelo) {
        modelo.addAttribute("articulo", articuloServicio.buscar(articulo));
        modelo.addAttribute("usuarios", usuarioServicio.listarUsuarios());
        return "modificarArticulo";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Articulo articulo) {
        articuloServicio.eliminar(articulo);
        return "redirect:/articulos";
    }
}
