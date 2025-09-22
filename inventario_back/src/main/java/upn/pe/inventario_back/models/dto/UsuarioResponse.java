package upn.pe.inventario_back.models.dto;

import lombok.Builder;

@Builder
public record UsuarioResponse(
        Long id,
        String documento,
        String nombre,
        String direccion,
        String telefono,
        String rol
) {
}
