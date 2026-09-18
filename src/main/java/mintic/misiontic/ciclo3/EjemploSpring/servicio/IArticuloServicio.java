package mintic.misiontic.ciclo3.EjemploSpring.servicio;

import mintic.misiontic.ciclo3.EjemploSpring.modelo.Articulo;
import java.util.List;

public interface IArticuloServicio {

    public List<Articulo> listarArticulos();

    public void guardar(Articulo articulo);

    public void eliminar(Articulo articulo);

    public Articulo buscar(Articulo articulo);
}
