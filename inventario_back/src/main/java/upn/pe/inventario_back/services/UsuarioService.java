package upn.pe.inventario_back.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import upn.pe.inventario_back.models.UsuarioModel;
import upn.pe.inventario_back.models.dto.LoginRequest;
import upn.pe.inventario_back.models.dto.UsuarioRequest;
import upn.pe.inventario_back.models.dto.UsuarioResponse;
import upn.pe.inventario_back.repositories.ClienteRepository;
import upn.pe.inventario_back.repositories.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    @Transactional
    public UsuarioResponse createUsuario(UsuarioRequest usuario) {
        UsuarioModel usuarionuevo = UsuarioModel.builder()
                .documento(usuario.documento())
                .nombre(usuario.nombre())
                .direccion(usuario.direccion())
                .telefono(usuario.telefono())
                .rol(usuario.rol())
                .build();
        UsuarioModel nuevoregistrado = usuarioRepository.save(usuarionuevo);

        return mapToUsuarioResponse(nuevoregistrado);
    }
    public List<UsuarioResponse> listUsuarios() {
        List<UsuarioModel> listusuarios = usuarioRepository.findAll();
        return listusuarios.stream().map(this::mapToUsuarioResponse).toList();
    }
    private UsuarioResponse mapToUsuarioResponse(UsuarioModel usuario){
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .documento(usuario.getDocumento())
                .nombre(usuario.getNombre())
                .direccion(usuario.getDireccion())
                .telefono(usuario.getTelefono())
                .rol(usuario.getRol())
                .build();
    }

    @Autowired
    UsuarioRepository repositorioUsuario;
    public Boolean eliminarCliente(Long id){
        try{
            if (repositorioUsuario.existsById(id)) {
                repositorioUsuario.deleteById(id);
                return true;
            } else {
                return false;
            }
        }
        catch(Exception e){
            return false;
        }
    }

    public Optional<UsuarioModel> consultarPorId(Long id){
        return repositorioUsuario.findById(id);
    }  
}
