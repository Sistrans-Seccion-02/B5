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
    @JoinColumn(name = "tipoUsuario", referencedColumnName = "tipoUsuario")
    private TipoUsuario tipoUsuario;
    private String correo;
    @ManyToOne(optional = true)
    @JoinColumn(name = "habitaciones_numeroHabitacion", referencedColumnName = "numeroHabitacion")
    private Habitacion habitaciones_numeroHabitacion;

    public Usuario(Integer id, String tipoId, String nombre, TipoUsuario tipoUsuario, String correo,
            Habitacion habitaciones_numeroHabitacion) {
        this.pk = new UsuarioPk(id, tipoId);
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
        this.correo = correo;
        this.habitaciones_numeroHabitacion = habitaciones_numeroHabitacion;
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
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Habitacion getHabitaciones_numeroHabitacion() {
        return habitaciones_numeroHabitacion;
    }

    public void setHabitaciones_numeroHabitacion(Habitacion habitaciones_numeroHabitacion) {
        this.habitaciones_numeroHabitacion = habitaciones_numeroHabitacion;
    }
}
