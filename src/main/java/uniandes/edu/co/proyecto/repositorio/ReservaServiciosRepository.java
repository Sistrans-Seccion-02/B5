package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bar;
import uniandes.edu.co.proyecto.modelo.Gimnasio;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Lavanderia;
import uniandes.edu.co.proyecto.modelo.Piscina;
import uniandes.edu.co.proyecto.modelo.ReservaServicios;
import uniandes.edu.co.proyecto.modelo.Restaurante;
import uniandes.edu.co.proyecto.modelo.Salon;
import uniandes.edu.co.proyecto.modelo.Spa;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface ReservaServiciosRepository extends JpaRepository<ReservaServicios, Integer>{

    @Query(value = "SELECT * FROM reservasServicios ", nativeQuery = true)
    Collection<Usuario> darReservaServicio();

    //select * from reservaServicios where id = :id
    @Query(value = "SELECT * FROM reservasServicios WHERE habitaciones_numeroHabitacion = :habitaciones_numeroHabitacion", nativeQuery = true)
    ReservaServicios darReservaServicioPorNumHabitacion(@Param("habitaciones_numeroHabitacion") Habitacion habitaciones_numeroHabitacion);

    //select * from reservaServicios where numReserva = :numReserva
    @Query(value = "SELECT * FROM reservasServicios WHERE numReserva = :numReserva", nativeQuery = true)
    ReservaServicios darReservaServicioPorNumReserva(@Param("numReserva") int numReserva);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservasServicios (fecha, atendida, habitaciones_numeroHabitacion, lavanderias_idTipoServicio, bares_idTipoServicio, spas_idTipoServicio, gimnasios_idTipoServicio, salones_idTipoServicio, restaurantes_idTipoServicio, piscinas_idTipoServicio) VALUES (:fecha, :atendida, :habitaciones_numeroHabitacion, :lavanderias_idTipoServicio, :bares_idTipoServicio, :spas_idTipoServicio, :gimnasios_idTipoServicio, :salones_idTipoServicio, :restaurantes_idTipoServicio, :piscinas_idTipoServicio)", nativeQuery = true)
    void crearReservaServicio(
    @Param("fecha") Date fecha,
    @Param("atendida") Boolean atendida,
    @Param("habitaciones_numeroHabitacion") Habitacion habitaciones_numeroHabitacion,
    @Param("lavanderias_idTipoServicio") Lavanderia lavanderias_idTipoServicio,
    @Param("bares_idTipoServicio") Bar bares_idTipoServicio,
    @Param("spas_idTipoServicio") Spa spas_idTipoServicio,
    @Param("gimnasios_idTipoServicio") Gimnasio gimnasios_idTipoServicio,
    @Param("salones_idTipoServicio") Salon salones_idTipoServicio,
    @Param("restaurantes_idTipoServicio") Restaurante restaurantes_idTipoServicio,
    @Param("piscinas_idTipoServicio") Piscina piscinas_idTipoServicio
    );
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE reservasServicios SET atendida= :atendida WHERE habitaciones_numeroHabitacion =:habitaciones_numeroHabitacion", nativeQuery = true)
    void actualizarReservaServicioAtendido(@Param("habitaciones_numeroHabitacion") Habitacion habitaciones_numeroHabitacion, @Param("atendida") Boolean atendida);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservasServicios SET fecha = :fecha, atendida = :atendida, habitaciones_numeroHabitacion = :habitaciones_numeroHabitacion, lavanderias_idTipoServicio = :lavanderias_idTipoServicio, bares_idTipoServicio = :bares_idTipoServicio, spas_idTipoServicio = :spas_idTipoServicio, gimnasios_idTipoServicio = :gimnasios_idTipoServicio, salones_idTipoServicio = :salones_idTipoServicio, restaurantes_idTipoServicio = :restaurantes_idTipoServicio, piscinas_idTipoServicio = :piscinas_idTipoServicio WHERE habitaciones_numeroHabitacion = :habitaciones_numeroHabitacion", nativeQuery = true)
    void actualizarReservaServicio(
        @Param("fecha") Date fecha,
        @Param("atendida") Boolean atendida,
        @Param("habitaciones_numeroHabitacion") Habitacion habitaciones_numeroHabitacion,
        @Param("lavanderias_idTipoServicio") Lavanderia lavanderias_idTipoServicio,
        @Param("bares_idTipoServicio") Bar bares_idTipoServicio,
        @Param("spas_idTipoServicio") Spa spas_idTipoServicio,
        @Param("gimnasios_idTipoServicio") Gimnasio gimnasios_idTipoServicio,
        @Param("salones_idTipoServicio") Salon salones_idTipoServicio,
        @Param("restaurantes_idTipoServicio") Restaurante restaurantes_idTipoServicio,
        @Param("piscinas_idTipoServicio") Piscina piscinas_idTipoServicio
    );
    


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservasServicios WHERE habitaciones_numeroHabitacion =:habitaciones_numeroHabitacion", nativeQuery = true)
    void eliminarReservaServicio(@Param("habitaciones_numeroHabitacion") Habitacion habitaciones_numeroHabitacion);

    // delete from reservaServicios where numReserva = :numReserva
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservasServicios WHERE numReserva =:numReserva", nativeQuery = true)
    void eliminarReservaServicioPorNumReserva(@Param("numReserva") int numReserva);
    
}
