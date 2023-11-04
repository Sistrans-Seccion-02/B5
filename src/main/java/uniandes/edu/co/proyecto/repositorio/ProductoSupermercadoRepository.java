package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ProductosSupermercado;

import java.util.Collection;


public interface ProductoSupermercadoRepository  extends JpaRepository<ProductosSupermercado, Integer>{

    @Query(value = "SELECT * FROM gustan", nativeQuery = true)
    Collection<ProductosSupermercado> darProductosSupermercados();

    @Query(value = "SELECT * FROM gustan WHERE supermercado_idTipoServicio = :supermercado_idTipoServicio AND productos_idProducto = :productos_idProducto", nativeQuery = true)
    ProductosSupermercado darProductoSupermercado(@Param("supermercado_idTipoServicio") Integer supermercado_idTipoServicio, @Param("productos_idProducto") Integer productos_idProducto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gustan WHERE supermercado_idTipoServicio = :supermercado_idTipoServicio AND productos_idProducto = :productos_idProducto", nativeQuery = true)
    void eliminarProductoSupermercado(@Param("supermercado_idTipoServicio") Integer supermercado_idTipoServicio, @Param("productos_idProducto") Integer productos_idProducto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gustan SET supermercado_idTipoServicio = :supermercado_idTipoServicio_actualizado, productos_idProducto = :productos_idProducto_actualizado WHERE supermercado_idTipoServicio = :supermercado_idTipoServicio AND productos_idProducto = :productos_idProducto", nativeQuery = true)
    void actualizarProductoSupermercado(@Param("supermercado_idTipoServicio") Integer supermercado_idTipoServicio, @Param("productos_idProducto") Integer productos_idProducto, @Param("supermercado_idTipoServicio_actualizado") Integer supermercado_idTipoServicio_actualizado, @Param("productos_idProducto_actualizado") Integer productos_idProducto_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gustan (supermercado_idTipoServicio, productos_idProducto) VALUES (:supermercado_idTipoServicio, :productos_idProducto)", nativeQuery = true)
    void insertarProductosSupermercado(@Param("supermercado_idTipoServicio") Integer supermercado_idTipoServicio, @Param("productos_idProducto") Integer productos_idProducto);

}