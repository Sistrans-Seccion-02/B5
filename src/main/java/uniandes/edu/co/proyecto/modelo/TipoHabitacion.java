package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiposhabitaciones")
public class TipoHabitacion {
    @Id
    private String tipohabitacion;

    public TipoHabitacion(String tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    public TipoHabitacion(){;}

    public String getTipoHabitacion() {
        return tipohabitacion;
    }

    public void setTipoHabitacion(String tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }
}
