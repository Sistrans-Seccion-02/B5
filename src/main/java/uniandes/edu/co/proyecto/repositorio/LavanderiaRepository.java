package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Lavanderia;

public interface LavanderiaRepository extends JpaRepository<Lavanderia, Integer>{

    @Query(value = "SELECT * FROM lavanderias ", nativeQuery = true)
    Collection<Lavanderia> darLavanderias();
    
    @Query(value = "SELECT * FROM lavanderias WHERE idTipoServicio = :idTipoServicio", nativeQuery = true)
    Lavanderia darLavanderia(@Param("idTipoServicio") int idTipoServicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO lavanderias (idTipoServicio, aplicaCompartido, nombreHotel) VALUES(proyecto_sequence.nextval, :aplicaCompartido, :nombreHotel) ", nativeQuery = true)
    void insertarLavanderia( @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") String nombreHotel);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE lavanderias SET aplicaCompartido= :aplicaCompartido, nombreHotel= :nombreHotel  WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void actualizarLavanderia(@Param("idTipoServicio") int idTipoServicio, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") String nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM lavanderias WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarLavanderia(@Param("idTipoServicio") int idTipoServicio);
    
}
