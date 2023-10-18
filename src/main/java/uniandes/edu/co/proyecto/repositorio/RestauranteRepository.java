package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Restaurante;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer>{

    @Query(value = "SELECT * FROM restaurantes ", nativeQuery = true)
    Collection<Usuario> darRestaurantes();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO restaurantes (idTipoServicio, aforo, estilo, aplicaCompartido, nombreHotel) VALUES(:idTipoServicio, :aforo, :estilo, :aplicaCompartido, :nombreHotel) ", nativeQuery = true)
    void insertarRestaurante(@Param("aforo") Integer aforo,
    @Param("estilo") String estilo,
    @Param("aplicaCompartido") Boolean aplicaCompartido,
    @Param("nombreHotel") Integer nombreHotel
    );
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE restaurantes SET aforo= :aforo,estilo= :estilo,aplicaCompartido= :aplicaCompartido,nombreHotel= :nombreHotel WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void actualizarRestaurante(@Param("idTipoServicio") int idTipoServicio, @Param("aforo") Integer aforo,
    @Param("estilo") String estilo,
    @Param("aplicaCompartido") Boolean aplicaCompartido,
    @Param("nombreHotel") Integer nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM idTipoServicio WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarRestaurante(@Param("idTipoServicio") int idTipoServicio);
    
}
