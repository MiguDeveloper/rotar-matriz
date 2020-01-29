package pe.tuna.rotarmatriz.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "mi_arreglos")
public class MiArreglo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;

    @Transient
    private List<List<Integer>> arregloEnteros;


    public MiArreglo() {
    }

    public MiArreglo(Long id, String imagen) {
        this.id = id;
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<List<Integer>> getArregloEnteros() {
        return arregloEnteros;
    }

    public void setArregloEnteros(List<List<Integer>> arregloEnteros) {
        this.arregloEnteros = arregloEnteros;
    }

}
