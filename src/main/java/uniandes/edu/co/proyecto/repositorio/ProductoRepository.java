package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

    @Query(value = "SELECT * FROM Productos ", nativeQuery = true)
    Collection<Producto> darPrestamoUtensilios();
    
    @Query(value = "SELECT * FROM Productos WHERE idProducto = :idProducto", nativeQuery = true)
    Producto darPrestamoUtensilios(@Param("idProducto") int idProducto);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Productos (idProducto, nombre, costo, aplicaIncluido, barId, restauranteId, tiendaId, lavanderiaId) VALUES(proyecto_sequence.nextval, :nombre, :costo, :aplicaIncluido, :barId, :restauranteId, :tiendaId, :lavanderiaId)", nativeQuery = true)
    void insertarPrestamoUtensilio(
        @Param("nombre") String nombre,
        @Param("costo") int costo,
        @Param("aplicaIncluido") Boolean aplicaIncluido,
        @Param("barId") int barId,
        @Param("restauranteId") int restauranteId,
        @Param("tiendaId") int tiendaId,
        @Param("lavanderiaId") int lavanderiaId
    );
    @Modifying
    @Transactional
    @Query(value = "UPDATE Productos SET nombre= :nombre, costo= :costo, aplicaIncluido= :aplicaIncluido, barId= :barId, restauranteId= :restauranteId, tiendaId= :tiendaId, lavanderiaId= :lavanderiaId   WHERE idProducto =:idProducto", nativeQuery = true)
    void actualizarPrestamoUtensilio(@Param("idProducto") int idProducto,@Param("nombre") String nombre,@Param("costo") int costo, @Param("aplicaIncluido") Boolean aplicaIncluido,@Param("barId") int barId,@Param("restauranteId") int restauranteId,@Param("tiendaId") int tiendaId,@Param("lavanderiaId") int lavanderiaId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Productos WHERE idProducto =:idProducto", nativeQuery = true)
    void eliminarPrestamoUtensilio(@Param("idProducto") int idProducto);
    
}
