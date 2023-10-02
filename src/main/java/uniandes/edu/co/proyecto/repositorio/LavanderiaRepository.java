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
    Collection<Lavanderia> darInternets();
    
    @Query(value = "SELECT * FROM lavanderias WHERE idTipoServicio = :idTipoServicio", nativeQuery = true)
    Lavanderia darInternet(@Param("idTipoServicio") int idTipoServicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO lavanderias (idTipoServicio, capacidad, aplicaCompartido, nombreHotel) VALUES(proyecto_sequence.nextval, :capacidad, :aplicaCompartido, :nombreHotel) ", nativeQuery = true)
    void insertarInternet(@Param("capacidad") int capacidad, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") String nombreHotel);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE lavanderias SET capacidad= :capacidad, aplicaCompartido= :aplicaCompartido, nombreHotel= :nombreHotel  WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void actualizarInternet(@Param("idTipoServicio") int idTipoServicio, @Param("capacidad") int capacidad, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") String nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM lavanderias WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarInternet(@Param("idTipoServicio") int idTipoServicio);
    
}
