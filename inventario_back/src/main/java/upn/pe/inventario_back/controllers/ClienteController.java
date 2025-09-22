package upn.pe.inventario_back.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upn.pe.inventario_back.models.Credenciales;
import upn.pe.inventario_back.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    ClienteService cs;

    @GetMapping
    public ArrayList<Credenciales> listarTodos(){
        return cs.listarCliente();
    }    
    @GetMapping(path= "/{id}")
    public  Optional<Credenciales> obtenercliente(@PathVariable("id") int id){
        return cs.consultarPorId(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")    
    @DeleteMapping(path= "/{id}")
    public  String eliminar(@PathVariable("id") Integer id){
        boolean r = this.cs.eliminarCliente(id);
        if(r){
            return "Cliente Eliminado";
        }
        else{
            return "no se pudo eliminar cliente";
        }
    }
}
