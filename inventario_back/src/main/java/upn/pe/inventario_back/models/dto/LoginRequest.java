package upn.pe.inventario_back.models.dto;

public record LoginRequest(
        String username,
        String password
) {}
