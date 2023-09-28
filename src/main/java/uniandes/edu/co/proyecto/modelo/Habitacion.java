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

    @ManyToOne
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    private TipoHabitacion tipo;



    public Habitacion(Integer numerohabitacion, TipoHabitacion tipo, Boolean disponibilidad)
    {
        this.numeroHabitacion = numerohabitacion;
        this.tipo = tipo;
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
    public TipoHabitacion getTipo() {
        return tipo;
    }
    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }
    public Boolean getDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    

    
}
