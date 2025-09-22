package upn.pe.inventario_back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upn.pe.inventario_back.models.Credenciales;
import upn.pe.inventario_back.services.CredencialesService;

@RestController
@RequestMapping("/credenciales")
public class CrendecialesController {

    @Autowired
    CredencialesService usuarioService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/login")
    public Credenciales login(@RequestBody Credenciales usuario) {
        return usuarioService.autenticar(usuario);     
    }

}
