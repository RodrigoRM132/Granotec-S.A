package upn.pe.inventario_back.models.dto;

public record UsuarioRequest(
        String documento,
        String nombre,
        String direccion,
        String telefono,
        String rol
) {
}
