package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class UsuarioPk implements Serializable{
    private Integer id;
    private String tipoId;

    public UsuarioPk(Integer id, String tipoId) {
        super();
        this.id = id;
        this.tipoId = tipoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }
}
