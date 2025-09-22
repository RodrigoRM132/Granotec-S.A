package upn.pe.inventario_back.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalle_salida")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleSalida {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Integer cantidad;
    private String nombre;
    private Double precioUnitario;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "salida_id", nullable = false)
    private Salida salida;

    @ManyToOne
    @JoinColumn(name = "kardex_id", nullable = false)
    private Kardex kardex;
}
