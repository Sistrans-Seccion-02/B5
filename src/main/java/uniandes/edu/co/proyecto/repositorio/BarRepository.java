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

    @Query(value = "SELECT * FROM bares WHERE idtiposervicio = :idtiposervicio", nativeQuery = true)
    Bar darBar(@Param("idtiposervicio") int idtiposervicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bares (idtiposervicio, estilo, aforo, aplicaCompartido, nombreHotel) VALUES(baresSeq.nextval, :estilo, :aforo, :aplicaCompartido, :nombreHotel) ", nativeQuery = true)
    void insertarBar(@Param("estilo") String estilo, @Param("aforo") int aforo, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") Hotel nombreHotel);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE bares SET estilo= :estilo, aforo= :aforo, aplicaCompartido= :aplicaCompartido, nombreHotel= :nombreHotel WHERE idtiposervicio =:idtiposervicio", nativeQuery = true)
    void actualizarBar(@Param("idtiposervicio") int idtiposervicio,@Param("estilo") String estilo, @Param("aforo") int aforo, @Param("aplicaCompartido") Boolean aplicaCompartido,  @Param("nombreHotel") String nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bares WHERE idtiposervicio =:idtiposervicio", nativeQuery = true)
    void eliminarBar(@Param("idtiposervicio") int idtiposervicio);
    
}
