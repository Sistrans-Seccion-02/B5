package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "salones")
public class Salon {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idTipoServicio;
    private Integer capacidad;
    private String equipo;
    private Boolean aplicaCompartido;

    public Salon(String equipo, Integer capacidad, Boolean aplicaCompartido)
    {
        this.equipo = equipo;
        this.capacidad = capacidad;
        this.aplicaCompartido = aplicaCompartido;
    }

    public Salon()
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

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public Boolean getAplicaCompartido() {
        return aplicaCompartido;
    }

    public void setAplicaCompartido(Boolean aplicaCompartido) {
        this.aplicaCompartido = aplicaCompartido;
    }

    


}
