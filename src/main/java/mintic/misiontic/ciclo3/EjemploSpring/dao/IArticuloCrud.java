package mintic.misiontic.ciclo3.EjemploSpring.dao;

import mintic.misiontic.ciclo3.EjemploSpring.modelo.Articulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IArticuloCrud extends CrudRepository<Articulo, String> {

    @Query("SELECT a FROM Articulo a WHERE LOWER(a.marca) LIKE LOWER(CONCAT('%', :marca, '%'))")
    List<Articulo> buscarPorMarca(@Param("marca") String marca);

    @Query("SELECT a FROM Articulo a WHERE LOWER(a.categoria) LIKE LOWER(CONCAT('%', :categoria, '%'))")
    List<Articulo> buscarPorCategoria(@Param("categoria") String categoria);

}
