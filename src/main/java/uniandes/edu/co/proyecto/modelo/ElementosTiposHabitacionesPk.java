package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ElementosTiposHabitacionesPk implements Serializable{
    @ManyToOne
    @JoinColumn(name = "tipohabitacion", referencedColumnName = "tipohabitacion")
    private TipoHabitacion tipohabitacion;
    @ManyToOne
    @JoinColumn(name = "nombreelemento", referencedColumnName = "nombreelemento")
    private ElementoExtra nombreelemento;

    public ElementosTiposHabitacionesPk(TipoHabitacion tipohabitacion, ElementoExtra nombreelemento) {
        super();
        this.tipohabitacion = tipohabitacion;
        this.nombreelemento = nombreelemento;
    }

    public ElementosTiposHabitacionesPk(){;}

    public TipoHabitacion getTipoHabitacion() {
        return tipohabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipohabitacion = tipoHabitacion;
    }

    public ElementoExtra getNombreElemento() {
        return nombreelemento;
    }

    public void setNombreElemento(ElementoExtra nombreElemento) {
        this.nombreelemento = nombreElemento;
    }
}
