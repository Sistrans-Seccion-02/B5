package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lavanderias")
public class Lavanderia {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idtiposervicio;
    private Boolean aplicacompartido;
    @ManyToOne(optional=true)
    @JoinColumn(name="hoteles_nombre", referencedColumnName="nombre")
    private Hotel nombrehotel;

    public Lavanderia(Boolean aplicaCompartido, Hotel nombreHotel)
    {
        this.aplicacompartido = aplicaCompartido;
        this.nombrehotel = nombreHotel;
    }

    public Lavanderia()
    {;}

    public Integer getIdTipoServicio() {
        return idtiposervicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idtiposervicio = idTipoServicio;
    }

    public Boolean getAplicaCompartido() {
        return aplicacompartido;
    }

    public void setAplicaCompartido(Boolean aplicaCompartido) {
        this.aplicacompartido = aplicaCompartido;
    }

    public Hotel getHotel() {
        return nombrehotel;
    }

    public void setHotel(Hotel nombreHotel) {
        this.nombrehotel = nombreHotel;
    }

}
