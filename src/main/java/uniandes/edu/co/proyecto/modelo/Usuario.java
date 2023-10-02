package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    private Integer id;
    private String tipoId;
    private String nombre;
    private String tipoUsuario;
    private String correo;
    @ManyToOne(optional=true)
    @JoinColumn(name="habitaciones_numeroHabitacion", referencedColumnName="numeroHabitacion")
    private Habitacion habitaciones_numeroHabitacion;

    public Usuario()
    {;}

    public Usuario(Integer id, String tipoId, String nombre, String tipoUsuario, String correo,
            Habitacion habitaciones_numeroHabitacion) {
        this.id = id;
        this.tipoId = tipoId;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
        this.correo = correo;
        this.habitaciones_numeroHabitacion = habitaciones_numeroHabitacion;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
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
