package upn.pe.inventario_back.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import upn.pe.inventario_back.models.Categoria;
import upn.pe.inventario_back.models.dto.CategoriaRequest;
import upn.pe.inventario_back.models.dto.CategoriaResponse;
import upn.pe.inventario_back.repositories.CategoriaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<CategoriaResponse> listarCategorias() {
        return categoriaRepository.findAll().stream()
                .map(this::mapToCategoriaResponse)
                .toList();
    }

    public void create(CategoriaRequest categoriaRequest) {
        Categoria nuevaCategoria = Categoria.builder()
                .nombre(categoriaRequest.nombre())
                .build();
        categoriaRepository.save(nuevaCategoria);
    }

    private CategoriaResponse mapToCategoriaResponse(Categoria categoria) {
        return CategoriaResponse.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .build();
    }
}
