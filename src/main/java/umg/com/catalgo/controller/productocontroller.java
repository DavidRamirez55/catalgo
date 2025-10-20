package umg.com.catalgo.controller;

import org.springframework.http.HttpStatus;
import umg.com.catalgo.model.producto;
import umg.com.catalgo.sevice.productoservice;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class productocontroller {
    private final productoservice service;

    public productocontroller(productoservice service) {
        this.service = service;
    }

    @GetMapping
    public List<producto> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<producto> buscar(@PathVariable Long id) {
        producto p = service.buscar(id);
        return (p == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<producto> crear(@Valid @RequestBody producto p) {
        producto guardado = service.crear(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<producto> actualizar(@PathVariable Long id, @Valid @RequestBody producto p) {
        return ResponseEntity.ok(service.actualizar(id, p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}