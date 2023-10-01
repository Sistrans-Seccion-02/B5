package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gimnasios")
public class Gimnasio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idTipoServicio;
    private Integer capacidad;
    private Integer numMaquinas;
    private String horario;
    private Boolean aplicaCompartido;

    public Gimnasio(Integer numMaquinas, Integer capacidad, String horario, Boolean aplicaCompartido)
    {
        this.capacidad = capacidad;
        this.numMaquinas = numMaquinas;
        this.horario = horario;
        this.aplicaCompartido = aplicaCompartido;
    }

    public Gimnasio()
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

    public Integer getNumMaquinas() {
        return numMaquinas;
    }

    public void setNumMaquinas(Integer numMaquinas) {
        this.numMaquinas = numMaquinas;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Boolean getAplicaCompartido() {
        return aplicaCompartido;
    }

    public void setAplicaCompartido(Boolean aplicaCompartido) {
        this.aplicaCompartido = aplicaCompartido;
    }

    
    



    
}
