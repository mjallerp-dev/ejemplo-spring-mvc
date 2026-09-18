package mintic.misiontic.ciclo3.EjemploSpring.dao;

import mintic.misiontic.ciclo3.EjemploSpring.modelo.Articulo;
import org.springframework.data.repository.CrudRepository;

public interface IArticuloCrud extends CrudRepository<Articulo, String> {

}
