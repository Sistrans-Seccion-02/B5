package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bares")
public class Bar {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idTipoServicio;
    private String estilo;
    private Integer aforo;
    private Boolean aplicaCompartido;
    @ManyToOne
    @JoinColumn(name="Hoteles_nombre", referencedColumnName="nombre")
    private Hotel nombreHotel;

    public Bar()
    {;}

    public Bar(String estilo, Integer aforo, Boolean aplicaCompartido, Hotel nombrHotel) {
        this.estilo = estilo;
        this.aforo = aforo;
        this.aplicaCompartido = aplicaCompartido;
        this.nombreHotel =nombrHotel;
    }

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public String getEstilo() {
        return estilo;
    }

    public Integer getAforo() {
        return aforo;
    }

    public Boolean getAplicaCompartido() {
        return aplicaCompartido;
    }


    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
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
