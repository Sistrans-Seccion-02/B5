package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.Internet;

public interface InternetRepository extends JpaRepository<Internet, Integer>{

    @Query(value = "SELECT * FROM serviciosinternet ", nativeQuery = true)
    Collection<Internet> darInternets();
    
    @Query(value = "SELECT * FROM serviciosinternet WHERE idTipoServicio = :idTipoServicio", nativeQuery = true)
    Internet darInternet(@Param("idTipoServicio") int idTipoServicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO serviciosinternet (idTipoServicio, incluido, aplicaCompartido, nombreHotel) VALUES(serviciosinternetSeq.nextval, :incluido, :aplicaCompartido, :nombreHotel) ", nativeQuery = true)
    void insertarInternet(@Param("incluido") Boolean incluido, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") Hotel nombreHotel);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE serviciosinternet SET  incluido= :incluido, aplicaCompartido= :aplicaCompartido, nombreHotel= :nombreHotel  WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void actualizarInternet(@Param("idTipoServicio") int idTipoServicio, @Param("incluido") Boolean incluido, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") Hotel nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM serviciosinternet WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarInternet(@Param("idTipoServicio") int idTipoServicio);
    
}
