package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "internets")
public class Internet {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idtiposervicio;
    private Boolean incluido;
    private Boolean aplicacompartido;
    @ManyToOne(optional=true)
    @JoinColumn(name="hotelesnombre", referencedColumnName="nombre")
    private Hotel nombrehotel;


    public Internet(Boolean incluido, Boolean aplicaCompartido, Hotel nombreHotel)
    {
        this.incluido = incluido;
        this.aplicacompartido = aplicaCompartido;
        this.nombrehotel = nombreHotel;
    }

    public Internet()
    {;}

    public Integer getIdTipoServicio() {
        return idtiposervicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idtiposervicio = idTipoServicio;
    }

    public Boolean getIncluido() {
        return incluido;
    }

    public void setIncluido(Boolean incluido) {
        this.incluido = incluido;
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
