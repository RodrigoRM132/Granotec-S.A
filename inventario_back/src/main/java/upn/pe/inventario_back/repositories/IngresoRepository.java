package upn.pe.inventario_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.inventario_back.models.Ingreso;

public interface IngresoRepository extends JpaRepository<Ingreso,String> {
}
