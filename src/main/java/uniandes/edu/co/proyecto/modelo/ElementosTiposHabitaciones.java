package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "elementosTiposHabitaciones")
public class ElementosTiposHabitaciones {
    @EmbeddedId
    private ElementosTiposHabitacionesPk pk;

    public ElementosTiposHabitaciones(TipoHabitacion tipoHabitacion, ElementoExtra nombreElemento) {
        this.pk = new ElementosTiposHabitacionesPk(tipoHabitacion, nombreElemento);
    }

    public ElementosTiposHabitaciones(){;}

    public ElementosTiposHabitacionesPk getPk() {
        return pk;
    }

    public void setPk(ElementosTiposHabitacionesPk pk) {
        this.pk = pk;
    }
}
