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
    private Integer idtiposervicio;
    private String nombre;
    private Boolean aplicacompartido;
    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hotel nombrehotel;

    public Supermercado()
    {;}

    public Supermercado(String nombre, Boolean aplicaCompartido, Hotel nombreHotel) {
        this.nombre = nombre;
        this.aplicacompartido = aplicaCompartido;
        this.nombrehotel = nombreHotel;
    }

    public Integer getIdTipoServicio() {
        return idtiposervicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idtiposervicio = idTipoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
