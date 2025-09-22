package upn.pe.inventario_back.services;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import upn.pe.inventario_back.models.*;
import upn.pe.inventario_back.models.dto.KardexResponse;
import upn.pe.inventario_back.models.dto.ProductoRequest;
import upn.pe.inventario_back.models.dto.ProductoResponse;
import upn.pe.inventario_back.models.dto.UsuarioResponse;
import upn.pe.inventario_back.repositories.CategoriaRepository;
import upn.pe.inventario_back.repositories.KardexRepository;
import upn.pe.inventario_back.repositories.LineaRepository;
import upn.pe.inventario_back.repositories.ProductoRepository;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final LineaRepository lineaRepository;
    private final KardexRepository kardexRepository;


    public List<ProductoResponse> listarProductos(){
        List<ProductoModel> productos = productoRepository.findAll();
        return productos.stream().map(this::mapToProductoResponse).toList();
    }
    public void create(ProductoRequest productoRequest) {
        Linea linea = lineaRepository.findById(productoRequest.linea_id()).orElseThrow();
        Categoria categoria = categoriaRepository.findById(productoRequest.categoria_id()).orElseThrow();
        ProductoModel nuevo = ProductoModel.builder()
                .nombre(productoRequest.nombre())
                .descripcion(productoRequest.descripcion())
                .precio(productoRequest.precio())
                .unidad_medida(productoRequest.unidad_medida())
                .categoria(categoria)
                .linea(linea)
                .build();
        productoRepository.save(nuevo);
    }
    public void delete(String id){
        productoRepository.deleteById(id);
    }
    public ProductoResponse getById(String id){
        ProductoModel producto = productoRepository.findById(id).orElseThrow();
        return mapToProductoResponse(producto);
    }
    private ProductoResponse mapToProductoResponse(ProductoModel producto){
        return ProductoResponse.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .Stock(producto.getStock())
                .unidad_medida(producto.getUnidad_medida())
                .categoria_id(producto.getCategoria().getId())
                .linea_id(producto.getLinea().getId())
                .build();
    }

    public List<KardexResponse> getkardex(String id) {
        List<Kardex> listaKardex = kardexRepository.findByProducto_IdOrderByFechaDesc(id);
        return listaKardex.stream().map(this::mapToKardexResponse).toList();
    }
    private KardexResponse mapToKardexResponse (Kardex kardex){
        return KardexResponse.builder()
                .id(kardex.getId())
                .fecha(kardex.getFecha())
                .cantidad(kardex.getCantidad())
                .stockActual(kardex.getStockActual())
                .usuario(mapToUsuarioResponse(kardex.getUsuario()))
                .build();
    }
    private UsuarioResponse mapToUsuarioResponse(UsuarioModel usuario){
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .documento(usuario.getDocumento())
                .nombre(usuario.getNombre())
                .direccion(usuario.getDireccion())
                .telefono(usuario.getTelefono())
                .build();
    }
}
