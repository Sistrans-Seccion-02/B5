package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.Supermercado;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface SupermercadoRepository extends JpaRepository<Supermercado, Integer>{

    @Query(value = "SELECT * FROM supermercados ", nativeQuery = true)
    Collection<Usuario> darSupermercados();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO supermercados (idTipoServicio, nombre, aplicaCompartido, nombreHotel) VALUES(proyecto_sequence.nextval, :nombre, :aplicaCompartido, :nombreHotel) ", nativeQuery = true)
    void insertarSupermercado(@Param("nombre") Integer nombre, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") Hotel nombreHotel);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE supermercados SET nombre= :nombre, aplicaCompartido= :aplicaCompartido, nombreHotel= :nombreHotel WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void actualizarSupermercado(@Param("idTipoServicio") int idTipoServicio, @Param("nombre") Integer nombre, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") Hotel nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM supermercados WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarSupermercado(@Param("idTipoServicio") int idTipoServicio);
   
}
