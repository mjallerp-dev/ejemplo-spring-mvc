package mintic.misiontic.ciclo3.EjemploSpring.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String cedula;
    private String clave;
    private String nombre;
    private String email;

}
