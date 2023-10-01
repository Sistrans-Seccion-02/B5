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
    private Integer idTipoServicio;
    private Integer aforo;
    private String estilo;
    private Boolean aplicaCompartido;
    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hotel hoteles_nombre;

    public Restaurante()
    {;}

    public Restaurante(Integer aforo, String estilo, Boolean aplicaCompartido, Hotel hoteles_nombre) {
        this.aforo = aforo;
        this.estilo = estilo;
        this.aplicaCompartido = aplicaCompartido;
        this.hoteles_nombre = hoteles_nombre;
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

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Boolean getAplicaCompartido() {
        return aplicaCompartido;
    }

    public void setAplicaCompartido(Boolean aplicaCompartido) {
        this.aplicaCompartido = aplicaCompartido;
    }

    public Hotel getHoteles_nombre() {
        return hoteles_nombre;
    }

    public void setHoteles_nombre(Hotel hoteles_nombre) {
        this.hoteles_nombre = hoteles_nombre;
    }
}
