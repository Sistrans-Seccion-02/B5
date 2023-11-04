package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "spas")
public class Spa {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idtiposervicio;
    private Integer duracion;
    private Boolean aplicacompartido;
    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hotel nombrehotel;

    public Spa()
    {;}

    public Spa(Integer duracion, Boolean aplicaCompartido, Hotel nombreHotel) {
        this.duracion = duracion;
        this.aplicacompartido = aplicaCompartido;
        this.nombrehotel = nombreHotel;
    }

    public Integer getIdTipoServicio() {
        return idtiposervicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idtiposervicio = idTipoServicio;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
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
