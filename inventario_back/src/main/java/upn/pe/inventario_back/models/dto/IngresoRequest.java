package upn.pe.inventario_back.models.dto;

import java.time.LocalDateTime;
import java.util.List;

public record IngresoRequest(
String documento,
String condicion,
String tipopago,
String formapago,
Double total,
Double gravada,
Double impuesto,
LocalDateTime fecha_emision,
LocalDateTime fecha_vencimiento,
Long usuarioEmpresa_id,
Long usuarioProveedor_id,
String nota,
List<DetalleIngresoRequest> detalles

) {
}
