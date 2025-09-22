package upn.pe.inventario_back.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private Double precio;
    
    @Column
    private int stock;

    @Column
    private String unidad_medida;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "linea_id", nullable = false)
    private Linea linea;

}
