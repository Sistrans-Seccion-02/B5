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

    private Integer idtiposervicio;
    private Integer aforo;
    private Integer profundidad;
    private Boolean aplicacompartido;
    @ManyToOne(optional=true)
    @JoinColumn(name="hotelesnombre", referencedColumnName="nombre")
    private Hotel nombrehotel;

    public Piscina(Integer profundidad, Integer aforo, Boolean aplicaCompartido, Hotel nombreHotel)
    {
        this.aforo = aforo;
        this.profundidad = profundidad;
        this.aplicacompartido = aplicaCompartido;
        this.nombrehotel = nombreHotel;
    }

    public Piscina()
    {;}

    public Integer getIdTipoServicio() {
        return idtiposervicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idtiposervicio = idTipoServicio;
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
        return aplicacompartido;
    }

    public void setAplicaCompartido(Boolean aplicaCompartido) {
        this.aplicacompartido = aplicaCompartido;
    }

    public Hotel getNombreHotel() {
        return nombrehotel;
    }

    public void setNombreHotel(Hotel nombreHotel) {
        this.nombrehotel = nombreHotel;
    }

    

}
