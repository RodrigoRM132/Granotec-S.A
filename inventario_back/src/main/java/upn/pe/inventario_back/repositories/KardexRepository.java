package upn.pe.inventario_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.inventario_back.models.Kardex;

import java.util.List;

public interface KardexRepository extends JpaRepository<Kardex,String> {
    List<Kardex> findByProducto_IdOrderByFechaDesc(String productoId);
}
