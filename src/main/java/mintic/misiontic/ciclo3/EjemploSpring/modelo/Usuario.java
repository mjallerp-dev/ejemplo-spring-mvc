package mintic.misiontic.ciclo3.EjemploSpring.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotEmpty
    @Column(name = "cedula", nullable = false, length = 15)
    private String cedula;
    @NotEmpty
    private String clave;
    @NotEmpty
    private String nombre;
    @NotEmpty
    @Email
    private String email;

}
