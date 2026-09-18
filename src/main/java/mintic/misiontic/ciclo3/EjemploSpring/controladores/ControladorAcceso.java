package mintic.misiontic.ciclo3.EjemploSpring.controladores;

import lombok.extern.slf4j.Slf4j;
import mintic.misiontic.ciclo3.EjemploSpring.modelo.Usuario;
import mintic.misiontic.ciclo3.EjemploSpring.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class ControladorAcceso {

    @Autowired
    IUsuarioServicio usuarioServicio;

    @Autowired
    JavaMailSender mailSender;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/recuperar")
    public String recuperar() {
        return "recuperar";
    }

    @PostMapping("/recuperar")
    public String enviarRecordatorio(@RequestParam String email, Model modelo) {
        Usuario usuario = usuarioServicio.buscarEmailExacto(email);
        if (usuario != null) {
            try {
                SimpleMailMessage mensaje = new SimpleMailMessage();
                mensaje.setTo(usuario.getEmail());
                mensaje.setSubject("Recuperación de Contraseña");
                mensaje.setText("Hola " + usuario.getNombre() + ",\n\n"
                        + "Recibimos una solicitud de recordatorio de clave en Ejemplo Spring MVC.\n\n"
                        + "Cédula: " + usuario.getCedula() + "\n"
                        + "Clave: " + usuario.getClave() + "\n\n"
                        + "Si no fuiste tú, inicia sesión y cambia la clave.\n\n"
                        + "Ejemplo Web MVC con Spring Boot");
                mailSender.send(mensaje);
            } catch (Exception e) {
                log.error("No se pudo enviar el correo de recordatorio", e);
            }
        }
        modelo.addAttribute("enviado", true);
        return "recuperar";
    }
}
