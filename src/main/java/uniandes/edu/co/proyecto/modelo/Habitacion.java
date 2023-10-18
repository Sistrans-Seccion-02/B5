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

    private Integer numeroHabitacion;
    private Boolean disponible;
    private String tipoHabitacion;


    public Habitacion(Integer numerohabitacion, String tipoHabitacion, Boolean disponible)
    {
        this.numeroHabitacion = numerohabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.disponible = disponible;
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
    public Boolean getDisponible() {
        return disponible;
    }
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    

    
}
