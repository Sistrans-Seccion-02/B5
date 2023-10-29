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
    private Integer numerohabitacion;
    @ManyToOne
    @JoinColumn(name = "tipohabitacion", referencedColumnName = "tipohabitacion")
    private TipoHabitacion tipohabitacion;

    public Habitacion(TipoHabitacion tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    public Habitacion(){;}

    public Integer getNumeroHabitacion() {
        return numerohabitacion;
    }

    public void setNumeroHabitacion(Integer numerohabitacion) {
        this.numerohabitacion = numerohabitacion;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipohabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }
}
