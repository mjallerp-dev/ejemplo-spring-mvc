package mintic.misiontic.ciclo3.EjemploSpring.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "articulos")
@Data
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotEmpty
    @Column(name = "id", nullable = false, length = 50)
    private String id;

    @NotEmpty
    @Column(length = 100)
    private String marca;

    @NotNull
    @Column(name = "precio_venta")
    private Double precioVenta;

    @NotNull
    @Column(name = "precio_compra")
    private Double precioCompra;

    @Column(name = "iva")
    private Double iva;

    @Column(length = 100)
    private String modelo;

    @Column(length = 100)
    private String proveedor;

    @Column(length = 100)
    private String tienda;

    @Min(0)
    private Integer cantidad;

    @Column(length = 255)
    private String descripcion;

    @Column(length = 100)
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_cedula")
    private Usuario usuario;

    @PrePersist
    @PreUpdate
    public void calcularIva() {
        if (this.precioVenta != null) {
            this.iva = this.precioVenta * 0.19;
        }
    }
}
