package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer numeroHabitacion;
    private Boolean disponibilidad;
    private String tipoHabitacion;


    public Habitacion(Integer numerohabitacion, String tipoHabitacion, Boolean disponibilidad)
    {
        this.numeroHabitacion = numerohabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.disponibilidad = disponibilidad;
    }
    public Habitacion()
    {;}
    
    public Integer getNumeroHabitacion() {
        return numeroHabitacion;
    }
    public void setNumeroHabitacion(Integer numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipo(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    public Boolean getDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    

    
}
