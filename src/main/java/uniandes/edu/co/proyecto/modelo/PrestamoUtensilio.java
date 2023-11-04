package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamosutensilios")
public class PrestamoUtensilio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idtiposervicio;
    private String nombre;
    private Boolean retornado;
    @ManyToOne(optional=true)
    @JoinColumn(name="hoteles_nombre", referencedColumnName="nombre")
    private Hotel nombrehotel;


    public PrestamoUtensilio(String nombre, Boolean retornado, Hotel nombreHotel)
    {
        this.nombre = nombre;
        this.retornado = retornado;
        this.nombrehotel = nombreHotel;
    }

    public PrestamoUtensilio()
    {;}

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

    public Boolean getRetornado() {
        return retornado;
    }

    public void setRetornado(Boolean retornado) {
        this.retornado = retornado;
    }

    public Hotel getNombreHotel() {
        return nombrehotel;
    }

    public void setNombreHotel(Hotel nombreHotel) {
        this.nombrehotel = nombreHotel;
    }

    
    
}
