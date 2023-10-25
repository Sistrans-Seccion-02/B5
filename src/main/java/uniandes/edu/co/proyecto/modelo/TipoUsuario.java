package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiposUsuarios")
public class TipoUsuario {
    @Id
    private String tipoUsuario;

    public TipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public TipoUsuario(){;}

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
