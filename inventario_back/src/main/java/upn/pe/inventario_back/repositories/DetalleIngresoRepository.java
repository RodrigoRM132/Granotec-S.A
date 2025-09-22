package upn.pe.inventario_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.inventario_back.models.DetalleIngreso;

public interface DetalleIngresoRepository extends JpaRepository<DetalleIngreso, String> {
}
