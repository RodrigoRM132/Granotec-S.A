package upn.pe.inventario_back.models.dto;

public record DetalleIngresoRequest(
        String nombre,
        Integer cantidad,
        Double precioUnitario,
        Double total,
        String producto_id
) {
}
