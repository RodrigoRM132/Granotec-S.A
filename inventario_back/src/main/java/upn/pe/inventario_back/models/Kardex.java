package upn.pe.inventario_back.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "kardex")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Kardex {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String  id;

    private LocalDateTime fecha;
    private Integer cantidad;
    private Integer stockActual;


    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductoModel producto;
}
