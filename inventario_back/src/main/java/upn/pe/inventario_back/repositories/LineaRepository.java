package upn.pe.inventario_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.inventario_back.models.Linea;

public interface LineaRepository extends JpaRepository<Linea, Long> {
}
