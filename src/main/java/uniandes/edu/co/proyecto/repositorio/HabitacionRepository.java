package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (numeroHabitacion, tipoHabitacion)"
        + " VALUES (habitacionesSeq.nextval, :tipoHabitacion)", nativeQuery = true)
    void insertarHabitacion(@Param("tipoHabitacion") String tipoHabitacion);

    @Query(value = "SELECT * FROM habitaciones", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitaciones WHERE numeroHabitacion = :numeroHabitacion", nativeQuery = true)
    Habitacion darHabitacion(@Param("numeroHabitacion") Integer numeroHabitacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET tipoHabitacion = :tipoHabitacion"
        + " WHERE numeroHabitacion = :numeroHabitacion", nativeQuery = true)
    void actualizarHabitacion(@Param("numeroHabitacion") Integer numeroHabitacion,
        @Param("tipoHabitacion") String tipoHabitacion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE numeroHabitacion = :numeroHabitacion", nativeQuery = true)
    void eliminarHabitacion(@Param("numeroHabitacion") Integer numeroHabitacion);
}
