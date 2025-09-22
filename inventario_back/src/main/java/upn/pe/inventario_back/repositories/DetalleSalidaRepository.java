package upn.pe.inventario_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.inventario_back.models.DetalleSalida;


public interface DetalleSalidaRepository extends JpaRepository<DetalleSalida, String> {
}
