package upn.pe.inventario_back.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upn.pe.inventario_back.models.Credenciales;
import upn.pe.inventario_back.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repositorioCliente;

    public ArrayList<Credenciales> listarCliente(){
        return (ArrayList<Credenciales>) repositorioCliente.findAll();
    }

    public Credenciales registrarCliente(Credenciales cli){
        return repositorioCliente.save(cli);
    }

    public Optional<Credenciales> consultarPorId(int id){
        return repositorioCliente.findById(id);
    }

    public Boolean eliminarCliente(Integer id){
        try{
            repositorioCliente.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }


}
