package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class ProductosSupermercadoPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "supermercado_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Supermercado supermercado_idTipoServicio;

    @ManyToOne
    @JoinColumn(name = "productos_idProducto", referencedColumnName = "idProducto")
    private Producto productos_idProducto;

    public ProductosSupermercadoPk(Supermercado supermercado_idTipoServicio, Producto productos_idProducto) {
        super();
        this.supermercado_idTipoServicio = supermercado_idTipoServicio;
        this.productos_idProducto = productos_idProducto;
    }

    public Supermercado getSupermercado_idTipoServicio() {
        return supermercado_idTipoServicio;
    }

    public void setSupermercado_idTipoServicio(Supermercado supermercado_idTipoServicio) {
        this.supermercado_idTipoServicio = supermercado_idTipoServicio;
    }

    public Producto getProductos_idProducto() {
        return productos_idProducto;
    }

    public void setProductos_idProducto(Producto productos_idProducto) {
        this.productos_idProducto = productos_idProducto;
    }
}