package mintic.misiontic.ciclo3.EjemploSpring.servicio;

import mintic.misiontic.ciclo3.EjemploSpring.modelo.Usuario;
import java.util.List;

public interface IUsuarioServicio {

    public List<Usuario> listarUsuarios();

    public void guardar(Usuario user);

    public void eliminar(Usuario user);

    public Usuario buscar(Usuario user);

    List<Usuario> buscarPorNombre(String nombre);

    List<Usuario> buscarPorEmail(String email);
}
