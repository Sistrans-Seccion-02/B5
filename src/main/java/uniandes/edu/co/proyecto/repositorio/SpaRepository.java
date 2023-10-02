package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Spa;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface SpaRepository extends JpaRepository<Spa, Integer>{

    @Query(value = "SELECT * FROM spas ", nativeQuery = true)
    Collection<Usuario> darSpas();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO spas (idTipoServicio, duracion, aplicaCompartido, hoteles_nombre) VALUES(proyecto_sequence.nextval, :duracion, :aplicaCompartido, :hoteles_nombre) ", nativeQuery = true)
    void insertarSpa(@Param("duracion") Integer duracion, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("hoteles_nombre") String hoteles_nombre);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE spas SET duracion= :duracion, aplicaCompartido= :aplicaCompartido, hoteles_nombre= :hoteles_nombre WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void actualizarSpa(@Param("idTipoServicio") int idTipoServicio, @Param("duracion") Integer duracion, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("hoteles_nombre") String hoteles_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM spas WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarSpa(@Param("idTipoServicio") int idTipoServicio);
    
}
