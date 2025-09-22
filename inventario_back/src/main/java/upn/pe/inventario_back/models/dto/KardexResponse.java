package upn.pe.inventario_back.models.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record KardexResponse(

        String id,
        LocalDateTime fecha,
        Integer cantidad,
        Integer stockActual,
        UsuarioResponse usuario
) {
}
