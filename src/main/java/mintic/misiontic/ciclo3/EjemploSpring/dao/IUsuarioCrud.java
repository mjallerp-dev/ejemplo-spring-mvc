package mintic.misiontic.ciclo3.EjemploSpring.dao;

import mintic.misiontic.ciclo3.EjemploSpring.modelo.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUsuarioCrud extends CrudRepository<Usuario, String> {

    @Query("SELECT u FROM Usuario u WHERE LOWER(u.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Usuario> buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT u FROM Usuario u WHERE LOWER(u.email) LIKE LOWER(CONCAT('%', :email, '%'))")
    List<Usuario> buscarPorEmail(@Param("email") String email);

}
