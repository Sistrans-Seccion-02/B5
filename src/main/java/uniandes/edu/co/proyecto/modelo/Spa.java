package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "spas")
public class Spa {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idTipoServicio;
    private Integer duracion;
    private Boolean aplicaCompartido;

    public Spa(Integer duracion,Boolean aplicaCompartido)
    {
        this.duracion = duracion;
        this.aplicaCompartido = aplicaCompartido;
    }

    public Spa()
    {;}

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Boolean getAplicaCompartido() {
        return aplicaCompartido;
    }

    public void setAplicaCompartido(Boolean aplicaCompartido) {
        this.aplicaCompartido = aplicaCompartido;
    }

    
    
}
