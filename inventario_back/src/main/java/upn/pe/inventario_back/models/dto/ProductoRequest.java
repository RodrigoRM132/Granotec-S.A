package upn.pe.inventario_back.models.dto;

public record ProductoRequest(
String nombre,
String descripcion,
Double precio,
String unidad_medida,
Long categoria_id,
Long linea_id
) {
}
