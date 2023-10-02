package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Gimnasio;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Integer>{

    @Query(value = "SELECT * FROM elementosExtras ", nativeQuery = true)
    Collection<Gimnasio> darGimnasios();

    @Query(value = "SELECT * FROM elementosExtras WHERE idTipoServicio = :idTipoServicio", nativeQuery = true)
    Gimnasio darGimnasio(@Param("idTipoServicio") int idTipoServicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO elementosExtras (idTipoServicio, capacidad, numMaquinas, horario, aplicaCompartido, nombreHotel) VALUES(proyecto_sequence.nextval, :capacidad, :numMaquinas, :horario, :aplicaCompartido, :nombreHotel) ", nativeQuery = true)
    void insertarGimnasio(@Param("capacidad") int capacidad, @Param("numMaquinas") int numMaquinas, @Param("horario") String horario, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") int nombreHotel);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE elementosExtras SET capacidad= :capacidad, numMaquinas = :numMaquinas, horario= :horario, aplicaCompartido= :aplicaCompartido, nombreHotel= :nombreHotel WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void actualizarGimnasio(@Param("idElemento") int idElemento, @Param("capacidad") int capacidad, @Param("numMaquinas") int numMaquinas, @Param("horario") String horario, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") int nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM elementosExtras WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarGimnasio(@Param("idTipoServicio") int idTipoServicio);

    
}
