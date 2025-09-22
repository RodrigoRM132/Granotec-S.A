package upn.pe.inventario_back.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import upn.pe.inventario_back.models.dto.LineaRequest;
import upn.pe.inventario_back.models.dto.LineaResponse;
import upn.pe.inventario_back.services.LineaService;

import java.util.List;

@RestController
@RequestMapping("/linea")
@RequiredArgsConstructor
public class LineaController {

    private final LineaService lineaService;

    @GetMapping
    public List<LineaResponse> listar() {
        return lineaService.listarLineas();
    }

    @PostMapping
    public void create(@RequestBody LineaRequest lineaRequest) {
        lineaService.create(lineaRequest);
    }
}