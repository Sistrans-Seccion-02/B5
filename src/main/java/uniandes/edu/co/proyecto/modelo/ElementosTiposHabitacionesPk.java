package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ElementosTiposHabitacionesPk implements Serializable{
    @ManyToOne
    @JoinColumn(name = "tipoHabitacion", referencedColumnName = "tipoHabitacion")
    private TipoHabitacion tipoHabitacion;
    @ManyToOne
    @JoinColumn(name = "nombreElemento", referencedColumnName = "nombreElemento")
    private ElementoExtra nombreElemento;

    public ElementosTiposHabitacionesPk(TipoHabitacion tipoHabitacion, ElementoExtra nombreElemento) {
        super();
        this.tipoHabitacion = tipoHabitacion;
        this.nombreElemento = nombreElemento;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public ElementoExtra getNombreElemento() {
        return nombreElemento;
    }

    public void setNombreElemento(ElementoExtra nombreElemento) {
        this.nombreElemento = nombreElemento;
    }
}
