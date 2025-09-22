package upn.pe.inventario_back.models.dto;

import lombok.Builder;

@Builder
public record LineaResponse(Long id, String nombre) {
}
