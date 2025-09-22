package upn.pe.inventario_back.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import upn.pe.inventario_back.models.UsuarioModel;
import upn.pe.inventario_back.models.dto.UsuarioRequest;
import upn.pe.inventario_back.models.dto.UsuarioResponse;

import upn.pe.inventario_back.services.UsuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/register")
    public UsuarioResponse create(@RequestBody UsuarioRequest usuario) {
        return usuarioService.createUsuario(usuario);
    }

    @GetMapping("/listar")
    public List<UsuarioResponse> list() {
        return usuarioService.listUsuarios();
    }

    @Autowired
    UsuarioService cs;
    @CrossOrigin(origins = "http://localhost:4200")    
    @DeleteMapping(path= "/{id}")
    public ResponseEntity<Map<String, String>> eliminar(@PathVariable("id") Long id) {
    boolean r = this.cs.eliminarCliente(id);
    Map<String, String> response = new HashMap<>();
    if (r) {
        response.put("message", "Cliente Eliminado");
        return ResponseEntity.ok(response); // Devuelve respuesta JSON
    } else {
        response.put("message", "No se pudo eliminar cliente");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}

    @GetMapping(path= "/{id}")
    public  Optional<UsuarioModel> obtenercliente(@PathVariable("id") Long id){
        return cs.consultarPorId(id);
    }
}
