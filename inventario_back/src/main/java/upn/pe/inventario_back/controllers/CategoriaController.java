package upn.pe.inventario_back.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import upn.pe.inventario_back.models.dto.CategoriaRequest;
import upn.pe.inventario_back.models.dto.CategoriaResponse;
import upn.pe.inventario_back.services.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaResponse> listar() {
        return categoriaService.listarCategorias();
    }

    @PostMapping
    public void create(@RequestBody CategoriaRequest categoriaRequest) {
        categoriaService.create(categoriaRequest);
    }
}