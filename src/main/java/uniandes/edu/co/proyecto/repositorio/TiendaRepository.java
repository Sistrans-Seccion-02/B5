package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Tienda;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface TiendaRepository extends JpaRepository<Tienda, Integer>{

    @Query(value = "SELECT * FROM tiendas ", nativeQuery = true)
    Collection<Usuario> darTiendas();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiendas (idTipoServicio, nombre, aplicaCompartido, hoteles_nombre) VALUES(proyecto_sequence.nextval, :nombre, :aplicaCompartido, :hoteles_nombre) ", nativeQuery = true)
    void insertarTienda(@Param("nombre") Integer nombre, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("hoteles_nombre") Integer hoteles_nombre);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE tiendas SET nombre= :nombre, aplicaCompartido= :aplicaCompartido, hoteles_nombre= :hoteles_nombre WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void actualizarTienda(@Param("idTipoServicio") int idTipoServicio, @Param("nombre") Integer nombre, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("hoteles_nombre") Integer hoteles_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiendas WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarTienda(@Param("idTipoServicio") int idTipoServicio);
    
}
