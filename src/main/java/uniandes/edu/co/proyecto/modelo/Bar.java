package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bares")
public class Bar {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idtiposervicio;
    private String estilo;
    private Integer aforo;
    private Boolean aplicacompartido;
    @ManyToOne
    @JoinColumn(name="hoteles_nombre", referencedColumnName="nombre")
    private Hotel nombrehotel;

    public Bar()
    {;}

    public Bar(String estilo, Integer aforo, Boolean aplicacompartido, Hotel nombrehotel) {
        this.estilo = estilo;
        this.aforo = aforo;
        this.aplicacompartido = aplicacompartido;
        this.nombrehotel = nombrehotel;
    }

    public Integer getIdtipoServicio() {
        return idtiposervicio;
    }

    public String getEstilo() {
        return estilo;
    }

    public Integer getAforo() {
        return aforo;
    }

    public Boolean getAplicaCompartido() {
        return aplicacompartido;
    }


    public void setIdtipoServicio(Integer idtipoServicio) {
        this.idtiposervicio = idtipoServicio;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public void setAplicaCompartido(Boolean aplicacompartido) {
        this.aplicacompartido = aplicacompartido;
    }

    public Hotel getNombreHotel() {
        return nombrehotel;
    }

    public void setNombreHotel(Hotel nombrehotel) {
        this.nombrehotel = nombrehotel;
    }
 
}
