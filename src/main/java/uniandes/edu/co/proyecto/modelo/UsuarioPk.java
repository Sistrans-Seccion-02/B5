package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class UsuarioPk implements Serializable{
    private Integer id;
    private String tipoid;

    public UsuarioPk(Integer id, String tipoid) {
        super();
        this.id = id;
        this.tipoid = tipoid;
    }

    public UsuarioPk(){;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoId() {
        return tipoid;
    }

    public void setTipoId(String tipoid) {
        this.tipoid = tipoid;
    }
}
