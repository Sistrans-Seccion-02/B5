package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "serviciosInternet")
public class Internet {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idTipoServicio;
    private Boolean incluido;
    private Boolean aplicaCompartido;
    @ManyToOne(optional=true)
    @JoinColumn(name="Hoteles_nombre", referencedColumnName="nombre")
    private String nombreHotel;


    public Internet(Boolean incluido, Boolean aplicaCompartido, String nombreHotel)
    {
        this.incluido = incluido;
        this.aplicaCompartido = aplicaCompartido;
        this.nombreHotel = nombreHotel;
    }

    public Internet()
    {;}

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
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

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }
    
    
    
}
