package upn.pe.inventario_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.inventario_back.models.Salida;

public interface SalidaRepository extends JpaRepository<Salida, String> {
}
