package upn.pe.inventario_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upn.pe.inventario_back.models.Credenciales;

@Repository
public interface ClienteRepository extends JpaRepository<Credenciales, Integer>{

}
