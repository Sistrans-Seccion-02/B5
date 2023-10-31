package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @EmbeddedId
    private UsuarioPk pk;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "tipousuario", referencedColumnName = "tipousuario")
    private TipoUsuario tipousuario;
    private String correo;
    @ManyToOne(optional = true)
    @JoinColumn(name = "habitaciones_numerohabitacion", referencedColumnName = "numerohabitacion")
    private Habitacion habitaciones_numerohabitacion;

    public Usuario(Integer id, String tipoid, String nombre, TipoUsuario tipousuario, String correo,
            Habitacion habitaciones_numerohabitacion) {
        this.pk = new UsuarioPk(id, tipoid);
        this.nombre = nombre;
        this.tipousuario = tipousuario;
        this.correo = correo;
        this.habitaciones_numerohabitacion = habitaciones_numerohabitacion;
    }

    public Usuario(){;}

    public UsuarioPk getPk() {
        return pk;
    }

    public void setPk(UsuarioPk pk) {
        this.pk = pk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoUsuario getTipoUsuario() {
        return tipousuario;
    }

    public void setTipoUsuario(TipoUsuario tipousuario) {
        this.tipousuario = tipousuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Habitacion getHabitaciones_numeroHabitacion() {
        return habitaciones_numerohabitacion;
    }

    public void setHabitaciones_numeroHabitacion(Habitacion habitaciones_numerohabitacion) {
        this.habitaciones_numerohabitacion = habitaciones_numerohabitacion;
    }
}
