package upn.pe.inventario_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upn.pe.inventario_back.models.ProductoModel;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel,String>{

}
