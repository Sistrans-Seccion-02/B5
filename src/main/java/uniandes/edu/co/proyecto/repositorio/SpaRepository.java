package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Spa;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface SpaRepository extends JpaRepository<Spa, Integer>{

    @Query(value = "SELECT * FROM spas ", nativeQuery = true)
    Collection<Usuario> darSpas();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO spas (idTipoServicio, duracion, aplicaCompartido, nombreHotel) VALUES(proyecto_sequence.nextval, :duracion, :aplicaCompartido, :nombreHotel) ", nativeQuery = true)
    void insertarSpa(@Param("duracion") Integer duracion, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") Integer nombreHotel);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE spas SET duracion= :duracion, aplicaCompartido= :aplicaCompartido, nombreHotel= :nombreHotel WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void actualizarSpa(@Param("idTipoServicio") int idTipoServicio, @Param("duracion") Integer duracion, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") Integer nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM spas WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarSpa(@Param("idTipoServicio") int idTipoServicio);
    
}
