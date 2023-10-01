package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "supermercados")
public class Supermercado {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idTipoServicio;
    private String nombre;
    private Boolean aplicaCompartido;
    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hotel hoteles_nombre;

    public Supermercado()
    {;}

    public Supermercado(String nombre, Boolean aplicaCompartido, Hotel hoteles_nombre) {
        this.nombre = nombre;
        this.aplicaCompartido = aplicaCompartido;
        this.hoteles_nombre = hoteles_nombre;
    }

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
