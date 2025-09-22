package upn.pe.inventario_back.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upn.pe.inventario_back.models.dto.IngresoRequest;
import upn.pe.inventario_back.services.IngresoService;

@RestController
@RequestMapping("/ingreso")
@RequiredArgsConstructor
public class IngresoController {
    private final IngresoService ingresoService;

    @PostMapping
    public void create(@RequestBody IngresoRequest ingresoRequest){
        ingresoService.create(ingresoRequest);
    }
}
