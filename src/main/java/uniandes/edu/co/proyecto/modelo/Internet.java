package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "internets")
public class Internet {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idTipoServicio;
    private Integer capacidad;
    private Boolean incluido;
    private Boolean aplicaCompartido;

    public Internet(Integer capacidad, Boolean incluido, Boolean aplicaCompartido)
    {
        this.capacidad = capacidad;
        this.incluido = incluido;
        this.aplicaCompartido = aplicaCompartido;
    }

    public Internet()
    {;}

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getIncluido() {
        return incluido;
    }

    public void setIncluido(Boolean incluido) {
        this.incluido = incluido;
    }

    public Boolean getAplicaCompartido() {
        return aplicaCompartido;
    }

    public void setAplicaCompartido(Boolean aplicaCompartido) {
        this.aplicaCompartido = aplicaCompartido;
    }
    
    
    
}
