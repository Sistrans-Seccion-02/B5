package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;

public interface TipoHabitacionRepository extends JpaRepository <TipoHabitacion, String>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiposHabitaciones (tipoHabitacion)"
        + " VALUES (:tipoHabitacion)", nativeQuery = true)
    void insertarTipoHabitacion(@Param("tipoHabitacion") String tipoHabitacion);

    @Query(value = "SELECT * FROM tiposHabitaciones", nativeQuery = true)
    Collection<TipoHabitacion> darTiposHabitacion();

    @Query(value = "SELECT * FROM tiposHabitaciones WHERE tipoHabitacion = :tipoHabitacion", nativeQuery = true)
    TipoHabitacion darTipoHabitacion(@Param("tipoHabitacion") String tipoHabitacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tiposHabitaciones SET tipoHabitacion = :tipoHabitacion_actualizado"
        + " WHERE tipoHabitacion = :tipoHabitacion", nativeQuery = true)
    void actualizarTipoHabitacion(@Param("tipoHabitacion") String tipoHabitacion,
        @Param("tipoHabitacion_actualizado") String tipoHabitacion_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiposHabitaciones WHERE tipoHabitacion = :tipoHabitacion", nativeQuery = true)
    void eliminarTipoHabitacion(@Param("tipoHabitacion") String tipoHabitacion);
}
