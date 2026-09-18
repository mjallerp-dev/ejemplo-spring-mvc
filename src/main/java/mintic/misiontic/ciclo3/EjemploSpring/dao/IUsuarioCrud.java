package mintic.misiontic.ciclo3.EjemploSpring.dao;

import mintic.misiontic.ciclo3.EjemploSpring.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioCrud extends CrudRepository<Usuario, String> {

}
