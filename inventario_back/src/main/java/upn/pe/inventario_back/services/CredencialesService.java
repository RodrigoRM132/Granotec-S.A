package upn.pe.inventario_back.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upn.pe.inventario_back.models.Credenciales;
import upn.pe.inventario_back.repositories.CredencialesRepository;

@Service
public class CredencialesService {

    @Autowired
    private CredencialesRepository usuarioRepository;


    public Credenciales autenticar(Credenciales usr){
        Credenciales r = null;
        ArrayList<Credenciales> lista = 
                                (ArrayList<Credenciales>) usuarioRepository.findAll();
        for(Credenciales u:lista){
            if(u.getUsername().equals(usr.getUsername()) && 
                                        u.getPassword().equals(usr.getPassword())){
                r=u;
            }
        }
        return r;
    }
}
