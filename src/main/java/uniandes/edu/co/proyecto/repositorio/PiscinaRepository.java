package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.Piscina;

public interface PiscinaRepository extends JpaRepository<Piscina, Integer>{

    @Query(value = "SELECT * FROM piscinas ", nativeQuery = true)
    Collection<Piscina> darPiscinas();
    
    @Query(value = "SELECT * FROM piscinas WHERE idTipoServicio = :idTipoServicio", nativeQuery = true)
    Piscina darPiscina(@Param("idTipoServicio") int idTipoServicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO piscinas (idTipoServicio, aforo, profundidad, aplicaCompartido, nombreHotel) VALUES(proyecto_sequence.nextval, :aforo, :profundidad, :aplicaCompartido, :nombreHotel) ", nativeQuery = true)
    void insertarPiscina(@Param("aforo") int aforo,@Param("profundidad") int profundidad, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") Hotel nombreHotel);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE piscinas SET aforo= :aforo, profundidad= :profundidad, aplicaCompartido= :aplicaCompartido, nombreHotel= :nombreHotel  WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void actualizarPiscina(@Param("idTipoServicio") int idTipoServicio,@Param("profundidad") int profundidad, @Param("aforo") int aforo, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") Hotel nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM piscinas WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarPiscina(@Param("idTipoServicio") int idTipoServicio);
    
}
