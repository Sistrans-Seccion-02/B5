package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="productosSupermercado")
public class ProductosSupermercado {

    @EmbeddedId
    private ProductosSupermercadoPk pk;

    public ProductosSupermercado()
    {;}

    public ProductosSupermercado(Supermercado supermercado_idTipoServicio, Producto productos_idProducto)
    {
        this.pk = new ProductosSupermercadoPk(supermercado_idTipoServicio, productos_idProducto);
    }

    public ProductosSupermercadoPk getPk() {
        return pk;
    }

    public void setPk(ProductosSupermercadoPk pk) {
        this.pk = pk;
    }
}