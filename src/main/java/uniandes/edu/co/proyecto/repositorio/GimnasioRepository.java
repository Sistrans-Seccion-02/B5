package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Gimnasio;
import uniandes.edu.co.proyecto.modelo.Hotel;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Integer>{

    @Query(value = "SELECT * FROM gimnasios ", nativeQuery = true)
    Collection<Gimnasio> darGimnasios();

    @Query(value = "SELECT * FROM gimnasios WHERE idtiposervicio = :idtiposervicio", nativeQuery = true)
    Gimnasio darGimnasio(@Param("idtiposervicio") int idtiposervicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gimnasios (idtiposervicio, aforo, numMaquinas, horario, aplicaCompartido, nombreHotel) VALUES(gimnasiosSeq.nextval, :aforo, :numMaquinas, :horario, :aplicaCompartido, :nombreHotel) ", nativeQuery = true)
    void insertarGimnasio(@Param("aforo") int aforo, @Param("numMaquinas") int numMaquinas, @Param("horario") String horario, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") Hotel nombreHotel);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE gimnasios SET aforo= :aforo, numMaquinas = :numMaquinas, horario= :horario, aplicaCompartido= :aplicaCompartido, nombreHotel= :nombreHotel WHERE idtiposervicio =:idtiposervicio", nativeQuery = true)
    void actualizarGimnasio(@Param("idtiposervicio") int idtiposervicio, @Param("aforo") int aforo, @Param("numMaquinas") int numMaquinas, @Param("horario") String horario, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") Hotel nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gimnasios WHERE idtiposervicio =:idtiposervicio", nativeQuery = true)
    void eliminarGimnasio(@Param("idtiposervicio") int idtiposervicio);

    
}
