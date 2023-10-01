package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamoUtensilios")
public class PrestamoUtensilio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idTipoServicio;
    private String nombre;
    private Boolean retornado;

    public PrestamoUtensilio(String nombre, Boolean retornado)
    {
        this.nombre = nombre;
        this.retornado = retornado;
    }

    public PrestamoUtensilio()
    {;}

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

    public Boolean getRetornado() {
        return retornado;
    }

    public void setRetornado(Boolean retornado) {
        this.retornado = retornado;
    }

    
    
}
