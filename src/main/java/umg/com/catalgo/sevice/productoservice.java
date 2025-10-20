package umg.com.catalgo.sevice;

import umg.com.catalgo.model.producto;
import umg.com.catalgo.repository.productorepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productoservice {
    private final productorepository repo;

    public productoservice(productorepository repo) {
        this.repo = repo;
    }

    public List<producto> listar() { return repo.findAll(); }
    public producto crear(producto p) { return repo.save(p); }
    public producto buscar(Long id) { return repo.findById(id).orElse(null); }
    public producto actualizar(Long id, producto datos) {
        producto p = repo.findById(id).orElseThrow();
        p.setNombre(datos.getNombre());
        p.setPrecio(datos.getPrecio());
        return repo.save(p);
    }
    public void eliminar(Long id) { repo.deleteById(id); }
}