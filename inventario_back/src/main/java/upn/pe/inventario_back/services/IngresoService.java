package upn.pe.inventario_back.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import upn.pe.inventario_back.models.*;
import upn.pe.inventario_back.models.dto.DetalleIngresoRequest;
import upn.pe.inventario_back.models.dto.IngresoRequest;
import upn.pe.inventario_back.repositories.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngresoService {

    private final IngresoRepository ingresoRepository;
    private final UsuarioRepository usuarioRepository;
    private final DetalleIngresoRepository detalleIngresoRepository;
    private final ProductoRepository productoRepository;
    private final KardexRepository kardexRepository;

    public void create(IngresoRequest ingresoRequest){
        UsuarioModel usuarioEmpresa = usuarioRepository.findById(ingresoRequest.usuarioEmpresa_id())
                .orElseThrow(() -> new RuntimeException("Usuario empresa no encontrado"));
        UsuarioModel usuarioProveedor = usuarioRepository.findById(ingresoRequest.usuarioProveedor_id())
                .orElseThrow(() -> new RuntimeException("Usuario proveedor no encontrado"));

        Ingreso nuevo = Ingreso.builder()
                .documento(ingresoRequest.documento())
                .condicion(ingresoRequest.condicion())
                .tipoPago(ingresoRequest.tipopago())
                .formapago(ingresoRequest.formapago())
                .total(ingresoRequest.total())
                .gravada(ingresoRequest.gravada())
                .impuesto(ingresoRequest.impuesto())
                .fecha_emision(ingresoRequest.fecha_emision())
                .fecha_vencimiento(ingresoRequest.fecha_vencimiento())
                .usuarioEmpresa(usuarioEmpresa)
                .usuarioProveedor(usuarioProveedor)
                .nota(ingresoRequest.nota())
                .build();

        Ingreso Ingresoregistrado = ingresoRepository.save(nuevo);
        List<String> productoIds = ingresoRequest.detalles().stream()
                .map(DetalleIngresoRequest::producto_id)
                .map(String::valueOf)
                .distinct()
                .toList();


        Map<String, ProductoModel> productos = productoRepository.findAllById(productoIds).stream()
                .collect(Collectors.toMap(ProductoModel::getId, producto -> producto));

        List<DetalleIngreso> detalles = new ArrayList<>();
        List<Kardex> kardexList = new ArrayList<>();


        //List<DetalleIngreso> detalles = new ArrayList<>();
         ingresoRequest.detalles().forEach(detalle -> {
             ProductoModel producto = productos.get(String.valueOf(detalle.producto_id()));
             if (producto == null) {
                 throw new RuntimeException("Producto no encontrado: " + detalle.producto_id());
             }
             Kardex kardex = Kardex.builder()
                     .cantidad(detalle.cantidad())
                     .fecha(LocalDateTime.now())
                     .producto(producto)
                     .usuario(usuarioProveedor)
                     .stockActual(producto.getStock() + detalle.cantidad())
                     .build();
             //Kardex kardexregistrado = kardexRepository.save(kardex);
             kardexList.add(kardex);

             DetalleIngreso nuevodetalle = DetalleIngreso.builder()
                     .nombre(detalle.nombre())
                     .cantidad(detalle.cantidad())
                     .precioUnitario(detalle.precioUnitario())
                     .total(detalle.total())
                     .ingreso(Ingresoregistrado)
                     .kardex(kardex)
                     .build();
             detalles.add(nuevodetalle);
             producto.setStock(producto.getStock() + detalle.cantidad());
         });
        kardexRepository.saveAll(kardexList);
        detalleIngresoRepository.saveAll(detalles);
        productoRepository.saveAll(productos.values());
    }
}
