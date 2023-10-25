package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ReservaHoteles;

public interface ReservaHotelesRepository extends JpaRepository<ReservaHoteles, Integer>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservasHoteles (numReserva, fechaEntrada, fechaSalida, pago, reservaTomada,"
        + " hoteles_nombre, habitaciones_numeroHabitacion, promociones_nombrePlan)"
        + " VALUES (reservasHotelesSeq.nextval, :fechaEntrada, :fechaSalida, :pago, :reservaTomada,"
        + " :hoteles_nombre, :habitaciones_numeroHabitacion, :promociones_nombrePlan)", nativeQuery = true)
    void insertarReservaHotel(@Param("fechaEntrada") Date fechaEntrada, @Param("fechaSalida") Date fechaSalida,
        @Param("pago") Boolean pago, @Param("reservaTomada") Boolean reservaTomada, @Param("hoteles_nombre") String hoteles_nombre,
        @Param("habitaciones_numeroHabitacion") Integer habitaciones_numeroHabitacion,
        @Param("promociones_nombrePlan") String promociones_nombrePlan);

    @Query(value = "SELECT * FROM reservasHoteles", nativeQuery = true)
    Collection<ReservaHoteles> darHoteles();

    @Query(value = "SELECT * FROM reservasHoteles WHERE numReserva = :numReserva", nativeQuery = true)
    ReservaHoteles darReservaHotel(@Param("numReserva") Integer numReserva);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservasHoteles SET fechaEntrada = :fechaEntrada, fechaSalida = :fechaSalida,"
        + " pago = :pago, reservaTomada = :reservaTomada, hoteles_nombre = :hoteles_nombre,"
        + " habitaciones_numeroHabitacion = :habitaciones_numeroHabitacion, promociones_nombrePlan = :promociones_nombrePlan"
        + " WHERE numReserva = :numReserva", nativeQuery = true)
    void actualizarReservaHotel(@Param("numReserva") Integer numReserva, @Param("fechaEntrada") Date fechaEntrada,
        @Param("fechaSalida") Date fechaSalida,
        @Param("pago") Boolean pago, @Param("reservaTomada") Boolean reservaTomada, @Param("hoteles_nombre") String hoteles_nombre,
        @Param("habitaciones_numeroHabitacion") Integer habitaciones_numeroHabitacion,
        @Param("promociones_nombrePlan") String promociones_nombrePlan);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservasHoteles WHERE numReserva = :numReserva", nativeQuery = true)
    void eliminarReservaHotel(@Param("numReserva") Integer numReserva);
}
