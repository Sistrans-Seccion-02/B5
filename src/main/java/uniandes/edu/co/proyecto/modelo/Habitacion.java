package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private Integer numeroHabitacion;
    private String tipo;
    private Boolean disponibilidad;

    public Habitacion(Integer numerohabitacion, String tipo, Boolean disponibilidad)
    {
        this.numeroHabitacion = numerohabitacion;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
    }
    public Habitacion()
    {;}
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getNumeroHabitacion() {
        return numeroHabitacion;
    }
    public void setNumeroHabitacion(Integer numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Boolean getDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    

    
}
