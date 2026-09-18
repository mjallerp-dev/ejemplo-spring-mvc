package mintic.misiontic.ciclo3.EjemploSpring.servicio;

import mintic.misiontic.ciclo3.EjemploSpring.dao.IArticuloCrud;
import mintic.misiontic.ciclo3.EjemploSpring.modelo.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticuloServicioImp implements IArticuloServicio {

    @Autowired
    IArticuloCrud crudArticulo;

    @Transactional(readOnly = true)
    @Override
    public List<Articulo> listarArticulos() {
        return (List<Articulo>) crudArticulo.findAll();
    }

    @Transactional
    @Override
    public void guardar(Articulo articulo) {
        crudArticulo.save(articulo);
    }

    @Transactional
    @Override
    public void eliminar(Articulo articulo) {
        crudArticulo.delete(articulo);
    }

    @Transactional(readOnly = true)
    @Override
    public Articulo buscar(Articulo articulo) {
        return crudArticulo.findById(articulo.getId()).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Articulo> buscarPorMarca(String marca) {
        return crudArticulo.buscarPorMarca(marca);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Articulo> buscarPorCategoria(String categoria) {
        return crudArticulo.buscarPorCategoria(categoria);
    }
}
