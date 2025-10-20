package umg.com.catalgo.repository;

import umg.com.catalgo.model.producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productorepository extends JpaRepository<producto, Long> {}