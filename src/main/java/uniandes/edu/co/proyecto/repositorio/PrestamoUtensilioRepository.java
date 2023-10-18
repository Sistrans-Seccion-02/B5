package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.PrestamoUtensilio;

public interface PrestamoUtensilioRepository extends JpaRepository<PrestamoUtensilio, Integer>{

    @Query(value = "SELECT * FROM prestamosUtensilios ", nativeQuery = true)
    Collection<PrestamoUtensilio> darPrestamoUtensilios();
    
    @Query(value = "SELECT * FROM prestamosUtensilios WHERE idTipoServicio = :idTipoServicio", nativeQuery = true)
    PrestamoUtensilio darPrestamoUtensilios(@Param("idTipoServicio") int idTipoServicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestamosUtensilios (idTipoServicio, nombre, retornado,  nombreHotel) VALUES(proyecto_sequence.nextval, :nombre, :retornado, :nombreHotel) ", nativeQuery = true)
    void insertarPrestamoUtensilio(@Param("nombre") String nombre,@Param("retornado") Boolean retornado, @Param("nombreHotel") String nombreHotel);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamosUtensilios SET capacidad= :capacidad, profundidad= :profundidad, aplicaCompartido= :aplicaCompartido, nombreHotel= :nombreHotel  WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void actualizarPrestamoUtensilio(@Param("idTipoServicio") int idTipoServicio,@Param("nombre") String nombre,@Param("retornado") Boolean retornado, @Param("nombreHotel") String nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestamosUtensilios WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarPrestamoUtensilio(@Param("idTipoServicio") int idTipoServicio);
    
}
