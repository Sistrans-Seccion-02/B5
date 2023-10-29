package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "elementostiposhabitaciones")
public class ElementosTiposHabitaciones {
    @EmbeddedId
    private ElementosTiposHabitacionesPk pk;

    public ElementosTiposHabitaciones(TipoHabitacion tipohabitacion, ElementoExtra nombreelemento) {
        this.pk = new ElementosTiposHabitacionesPk(tipohabitacion, nombreelemento);
    }

    public ElementosTiposHabitaciones(){;}

    public ElementosTiposHabitacionesPk getPk() {
        return pk;
    }

    public void setPk(ElementosTiposHabitacionesPk pk) {
        this.pk = pk;
    }
}
