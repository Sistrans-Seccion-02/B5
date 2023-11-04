package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurantes")
public class Restaurante {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idtiposervicio;
    private Integer aforo;
    private String estilo;
    private Boolean aplicacompartido;
    @ManyToOne(optional=true)
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hotel nombrehotel;

    public Restaurante()
    {;}

    public Restaurante(Integer aforo, String estilo, Boolean aplicaCompartido, Hotel nombreHotel) {
        this.aforo = aforo;
        this.estilo = estilo;
        this.aplicacompartido = aplicaCompartido;
        this.nombrehotel = nombreHotel;
    }

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

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
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
