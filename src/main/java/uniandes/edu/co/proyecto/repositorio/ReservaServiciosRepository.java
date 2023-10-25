package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ReservaServicios;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface ReservaServiciosRepository extends JpaRepository<ReservaServicios, Integer>{

    @Query(value = "SELECT * FROM reservaServicios ", nativeQuery = true)
    Collection<Usuario> darReservaServicio();

    //select * from reservaServicios where id = :id
    @Query(value = "SELECT * FROM reservaServicios WHERE habitaciones_numeroHabitacion = :habitaciones_numeroHabitacion", nativeQuery = true)
    ReservaServicios darReservaServicioPorId(@Param("habitaciones_numeroHabitacion") int habitaciones_numeroHabitacion);

    //select * from reservaServicios where numReserva = :numReserva
    @Query(value = "SELECT * FROM reservaServicios WHERE numReserva = :numReserva", nativeQuery = true)
    ReservaServicios darReservaServicioPorNumReserva(@Param("numReserva") int numReserva);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservaServicios (fecha, atendida, habitaciones_numeroHabitacion, lavanderias_idTipoServicio, bares_idTipoServicio, spas_idTipoServicio, gimnasios_idTipoServicio, salones_idTipoServicio, restaurantes_idTipoServicio, piscinas_idTipoServicio) VALUES (:fecha, :atendida, :habitaciones_numeroHabitacion, :lavanderias_idTipoServicio, :bares_idTipoServicio, :spas_idTipoServicio, :gimnasios_idTipoServicio, :salones_idTipoServicio, :restaurantes_idTipoServicio, :piscinas_idTipoServicio)", nativeQuery = true)
    void crearReservaServicio(@Param("fecha") Date fecha,
    @Param("atendida") Boolean atendida,
    @Param("habitaciones_numeroHabitacion") Integer habitaciones_numeroHabitacion,
    @Param("lavanderias_idTipoServicio") Integer lavanderias_idTipoServicio,
    @Param("bares_idTipoServicio") Integer bares_idTipoServicio,
    @Param("spas_idTipoServicio") Integer spas_idTipoServicio,
    @Param("gimnasios_idTipoServicio") Integer gimnasios_idTipoServicio,
    @Param("salones_idTipoServicio") Integer salones_idTipoServicio,
    @Param("restaurantes_idTipoServicio") Integer restaurantes_idTipoServicio,
    @Param("piscinas_idTipoServicio") Integer piscinas_idTipoServicio
    );
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE reservaServicios SET atendida= :atendida WHERE habitaciones_numeroHabitacion =:habitaciones_numeroHabitacion", nativeQuery = true)
    void actualizarReservaServicioAtendido(@Param("habitaciones_numeroHabitacion") int habitaciones_numeroHabitacion, @Param("atendida") Boolean atendida);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservaServicios SET atendida= :atendida, habitaciones_numeroHabitacion= :habitaciones_numeroHabitacion, lavanderias_idTipoServicio= :lavanderias_idTipoServicio, bares_idTipoServicio= :bares_idTipoServicio, spas_idTipoServicio= :spas_idTipoServicio, gimnasios_idTipoServicio= :gimnasios_idTipoServicio, salones_idTipoServicio= :salones_idTipoServicio, restaurantes_idTipoServicio= :restaurantes_idTipoServicio, piscinas_idTipoServicio= :piscinas_idTipoServicio WHERE habitaciones_numeroHabitacion =:habitaciones_numeroHabitacion", nativeQuery = true)
    void actualizarReservaServicio(@Param("fecha") Date fecha,
    @Param("atendida") Boolean atendida,
    @Param("habitaciones_numeroHabitacion") Integer habitaciones_numeroHabitacion,
    @Param("lavanderias_idTipoServicio") Integer lavanderias_idTipoServicio,
    @Param("bares_idTipoServicio") Integer bares_idTipoServicio,
    @Param("spas_idTipoServicio") Integer spas_idTipoServicio,
    @Param("gimnasios_idTipoServicio") Integer gimnasios_idTipoServicio,
    @Param("salones_idTipoServicio") Integer salones_idTipoServicio,
    @Param("restaurantes_idTipoServicio") Integer restaurantes_idTipoServicio,
    @Param("piscinas_idTipoServicio") Integer piscinas_idTipoServicio
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservaServicios WHERE habitaciones_numeroHabitacion =:habitaciones_numeroHabitacion", nativeQuery = true)
    void eliminarReservaServicio(@Param("habitaciones_numeroHabitacion") int habitaciones_numeroHabitacion);

    // delete from reservaServicios where numReserva = :numReserva
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservaServicios WHERE numReserva =:numReserva", nativeQuery = true)
    void eliminarReservaServicioPorNumReserva(@Param("numReserva") int numReserva);
    
}
