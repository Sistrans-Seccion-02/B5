package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idProducto;
    private String nombre;
    private Integer costo;
    private Boolean aplicaIncluido;
    @ManyToOne
    @JoinColumn(name="BarId", referencedColumnName="idTipoServicio")
    private Bar barId;
    @ManyToOne
    @JoinColumn(name="RestauranteId", referencedColumnName="idTipoServicio")
    private Restaurante restauranteId;
    @ManyToOne
    @JoinColumn(name="TiendaId", referencedColumnName="idTipoServicio")
    private Tienda tiendaId;
    @ManyToOne
    @JoinColumn(name="LavanderiaId", referencedColumnName="idTipoServicio")
    private Lavanderia lavanderiaId;

    public Producto(Boolean aplicaIncluido, String nombre, Integer costo, Bar barId, Restaurante restauranteId, Tienda tiendaId, Lavanderia lavanderiaId)
    {
        this.aplicaIncluido = aplicaIncluido;
        this.nombre = nombre;
        this.costo = costo;
        this.barId = barId;
        this.restauranteId = restauranteId;
        this.tiendaId = tiendaId;
        this.lavanderiaId = lavanderiaId;
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

    public Bar getBarId() {
        return barId;
    }

    public void setBarId(Bar barId) {
        this.barId = barId;
    }

    public Restaurante getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Restaurante restauranteId) {
        this.restauranteId = restauranteId;
    }

    public Tienda getTiendaId() {
        return tiendaId;
    }

    public void setTiendaId(Tienda tiendaId) {
        this.tiendaId = tiendaId;
    }

    public Lavanderia getLavanderiaId() {
        return lavanderiaId;
    }

    public void setLavanderiaId(Lavanderia lavanderiaId) {
        this.lavanderiaId = lavanderiaId;
    }

    

}