package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "salones")
public class Salon {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idTipoServicio;
    private Integer aforo;
    private String equipo;
    private Boolean aplicaCompartido;
    @ManyToOne
    @JoinColumn(name = "Hoteles_nombre", referencedColumnName = "nombre")
    private Hotel nombreHotel;

    public Salon()
    {;}

    public Salon(Integer aforo, String equipo, Boolean aplicaCompartido, Hotel nombreHotel) {
        this.aforo = aforo;
        this.equipo = equipo;
        this.aplicaCompartido = aplicaCompartido;
        this.nombreHotel = nombreHotel;
    }

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

    public Hotel getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(Hotel nombreHotel) {
        this.nombreHotel = nombreHotel;
    }
}
