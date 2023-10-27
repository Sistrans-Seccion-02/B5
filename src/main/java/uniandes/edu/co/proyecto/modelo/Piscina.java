package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "piscinas")
public class Piscina {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idTipoServicio;
    private Integer aforo;
    private Integer profundidad;
    private Boolean aplicaCompartido;
    @ManyToOne(optional=true)
    @JoinColumn(name="Hoteles_nombre", referencedColumnName="nombre")
    private String nombreHotel;

    public Piscina(Integer profundidad, Integer aforo, Boolean aplicaCompartido, String nombreHotel)
    {
        this.aforo = aforo;
        this.profundidad = profundidad;
        this.aplicaCompartido = aplicaCompartido;
        this.nombreHotel = nombreHotel;
    }

    public Piscina()
    {;}

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public Integer getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }

    public Boolean getAplicaCompartido() {
        return aplicaCompartido;
    }

    public void setAplicaCompartido(Boolean aplicaCompartido) {
        this.aplicaCompartido = aplicaCompartido;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    

}
