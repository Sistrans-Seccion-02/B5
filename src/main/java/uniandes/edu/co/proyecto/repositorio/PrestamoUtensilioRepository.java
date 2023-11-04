package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.PrestamoUtensilio;

public interface PrestamoUtensilioRepository extends JpaRepository<PrestamoUtensilio, Integer>{

    @Query(value = "SELECT * FROM prestamosUtensilios ", nativeQuery = true)
    Collection<PrestamoUtensilio> darPrestamoUtensilios();
    
    @Query(value = "SELECT * FROM prestamosutensilios WHERE idTipoServicio = :idTipoServicio", nativeQuery = true)
    PrestamoUtensilio darPrestamoUtensilio(@Param("idTipoServicio") int idTipoServicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestamosutensilios (nombre, retornado, nombreHotel) VALUES(:nombre, :retornado, :nombreHotel)", nativeQuery = true)
    void insertarPrestamoUtensilio(@Param("nombre") String nombre, @Param("retornado") Boolean retornado, @Param("nombreHotel") Hotel nombreHotel);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamosutensilios SET nombre = :nombre, retornado = :retornado, nombreHotel = :nombreHotel WHERE idTipoServicio = :idTipoServicio", nativeQuery = true)
    void actualizarPrestamoUtensilio(@Param("idTipoServicio") int idTipoServicio,
                                    @Param("nombre") String nombre,
                                    @Param("retornado") Boolean retornado,
                                    @Param("nombreHotel") Hotel nombreHotel);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestamosutensilios WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarPrestamoUtensilio(@Param("idTipoServicio") int idTipoServicio);
    
}
