package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Productos")
public class Producto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idProducto;
    private String nombre;
    private Integer costo;
    private Boolean aplicaIncluido;

    public Producto(Boolean aplicaIncluido, String nombre, Integer costo)
    {
        this.aplicaIncluido = aplicaIncluido;
        this.nombre = nombre;
        this.costo = costo;
    }

    public Producto()
    {;}

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Boolean getAplicaIncluido() {
        return aplicaIncluido;
    }

    public void setAplicaIncluido(Boolean aplicaIncluido) {
        this.aplicaIncluido = aplicaIncluido;
    }

    

}