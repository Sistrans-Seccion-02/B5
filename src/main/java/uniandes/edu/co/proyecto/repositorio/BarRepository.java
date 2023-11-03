package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bar;
import uniandes.edu.co.proyecto.modelo.Hotel;

public interface BarRepository extends JpaRepository<Bar, Integer>{

    @Query(value = "SELECT * FROM bares ", nativeQuery = true)
    Collection<Bar> darBares();

    @Query(value = "SELECT * FROM bares WHERE idTipoServicio = :idTipoServicio", nativeQuery = true)
    Bar darBar(@Param("idTipoServicio") int idTipoServicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bares (idTipoServicio, estilo, aforo, aplicaCompartido, nombreHotel) VALUES(proyecto_sequence.nextval, :estilo, :aforo, :aplicaCompartido, :nombreHotel) ", nativeQuery = true)
    void insertarBar(@Param("estilo") String estilo, @Param("aforo") int aforo, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") Hotel nombreHotel);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE bares SET estilo= :estilo, aforo= :aforo, aplicaCompartido= :aplicaCompartido, nombreHotel= :nombreHotel WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void actualizarBar(@Param("idTipoServicio") int idTipoServicio,@Param("estilo") String estilo, @Param("aforo") int aforo, @Param("aplicaCompartido") Boolean aplicaCompartido,  @Param("nombreHotel") Hotel nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bares WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarBar(@Param("idTipoServicio") int idTipoServicio);
    
}
