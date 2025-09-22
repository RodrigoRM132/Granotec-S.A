package upn.pe.inventario_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.inventario_back.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
