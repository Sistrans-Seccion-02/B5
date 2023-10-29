package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiposusuarios")
public class TipoUsuario {
    @Id
    private String tipousuario;

    public TipoUsuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    public TipoUsuario(){;}

    public String getTipoUsuario() {
        return tipousuario;
    }

    public void setTipoUsuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }
}
