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

    private String output;

    @Transient
    private List<List<Integer>> input;


    public MiArreglo() {
    }

    public MiArreglo(Long id, String output) {
        this.id = id;
        this.output = output;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String imagen) {
        this.output = imagen;
    }

    public List<List<Integer>> getInput() {
        return input;
    }

    public void setInput(List<List<Integer>> input) {
        this.input = input;
    }

}
