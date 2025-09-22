package upn.pe.inventario_back.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upn.pe.inventario_back.models.dto.SalidaRequest;
import upn.pe.inventario_back.services.SalidaService;

@RestController
@RequestMapping("/salida")
@RequiredArgsConstructor
public class SalidaController {

    private final SalidaService salidaService;

    @PostMapping
    public void create(@RequestBody SalidaRequest salidaRequest){
        salidaService.create(salidaRequest);
    }
}
