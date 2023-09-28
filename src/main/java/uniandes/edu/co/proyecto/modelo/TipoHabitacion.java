package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipoHabitaciones")
public class TipoHabitacion {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String tipo;
    private String dotacion;
    private Integer costo;

    public TipoHabitacion(String tipo, String dotacion, Integer costo)
    {
        this.tipo = tipo;
        this.dotacion = dotacion;
        this.costo = costo;
    }
    public TipoHabitacion()
    {;}
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDotacion() {
        return dotacion;
    }
    public void setDotacion(String dotacion) {
        this.dotacion = dotacion;
    }
    public Integer getCosto() {
        return costo;
    }
    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    
    
}
