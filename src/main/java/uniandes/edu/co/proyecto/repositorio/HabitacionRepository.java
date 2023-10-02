package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{

    @Query(value = "SELECT * FROM habitaciones ", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();
    
    @Query(value = "SELECT * FROM habitaciones WHERE numeroHabitacion = :numeroHabitacion", nativeQuery = true)
    Habitacion darHabitacion(@Param("numeroHabitacion") int numeroHabitacions);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (numeroHabitacion, disponibilidad) VALUES(proyecto_sequence.nextval, :disponibilidad) ", nativeQuery = true)
    void insertarHabitacion(@Param("disponibilidad") Boolean disponibilidad);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET disponibilidad= :disponibilidad WHERE numeroHabitacion =:numeroHabitacion", nativeQuery = true)
    void actualizarHabitacion(@Param("numeroHabitacion") int numeroHabitacion, @Param("disponibilidad") Boolean disponibilidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE numeroHabitacion =:numeroHabitacion", nativeQuery = true)
    void eliminarHabitacion(@Param("numeroHabitacion") int numeroHabitacion);
    
}
