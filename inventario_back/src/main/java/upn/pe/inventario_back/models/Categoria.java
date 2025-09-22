package upn.pe.inventario_back.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoModel> productos = new ArrayList<>();


    public void addProducto(ProductoModel producto) {
        productos.add(producto);
        producto.setCategoria(this);
    }

    public void removeProducto(ProductoModel producto) {
        productos.remove(producto);
        producto.setCategoria(null);
    }
}
