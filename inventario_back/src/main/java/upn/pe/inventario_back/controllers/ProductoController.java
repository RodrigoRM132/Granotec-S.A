package upn.pe.inventario_back.controllers;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import upn.pe.inventario_back.models.dto.KardexResponse;
import upn.pe.inventario_back.models.dto.ProductoRequest;
import upn.pe.inventario_back.models.dto.ProductoResponse;
import upn.pe.inventario_back.services.ProductoService;


@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public List<ProductoResponse> listar(){
        return productoService.listarProductos();
    }
    @GetMapping("/{id}")
    public ProductoResponse getById(@PathVariable String id) {
        return productoService.getById(id);
    }
    @GetMapping("/kardex/{id}")
    public List<KardexResponse> getkardex(@PathVariable String id) {
        return productoService.getkardex(id);
    }

    @PostMapping
    public void create(@RequestBody ProductoRequest producto){
        productoService.create(producto);
    }

}
