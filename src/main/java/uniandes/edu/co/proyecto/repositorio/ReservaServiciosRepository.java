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

    @Query(value = "SELECT * FROM reservaServicios ", nativeQuery = true)
    Collection<Usuario> darReservaServicio();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservaServicios (fecha, atendida, habitaciones_numeroHabitacion, lavanderias_idTipoServicio, bares_idTipoServicio, spas_idTipoServicio, gimnasio_idTipoServicio, salon_idTipoServicio, restaurante_idTipoServicio, piscina_idTipoServicio) VALUES(:fecha, :atendida, :habitaciones_numeroHabitacion, :lavanderias_idTipoServicio, :bares_idTipoServicio, :spas_idTipoServicio, :gimnasio_idTipoServicio, :salon_idTipoServicio, :restaurante_idTipoServicio, :piscina_idTipoServicio) ", nativeQuery = true)
    void insertarReservaServicio(@Param("fecha") Date fecha,
    @Param("atendida") Boolean atendida,
    @Param("habitaciones_numeroHabitacion") Habitacion habitaciones_numeroHabitacion,
    @Param("lavanderias_idTipoServicio") Lavanderia lavanderias_idTipoServicio,
    @Param("bares_idTipoServicio") Bar bares_idTipoServicio,
    @Param("spas_idTipoServicio") Spa spas_idTipoServicio,
    @Param("gimnasio_idTipoServicio") Gimnasio gimnasio_idTipoServicio,
    @Param("salon_idTipoServicio") Salon salon_idTipoServicio,
    @Param("restaurante_idTipoServicio") Restaurante restaurante_idTipoServicio,
    @Param("piscina_idTipoServicio") Piscina piscina_idTipoServicio
    );
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE reservaServicios SET atendida= :atendida WHERE habitaciones_numeroHabitacion =:habitaciones_numeroHabitacion", nativeQuery = true)
    void actualizarHabitacion(@Param("habitaciones_numeroHabitacion") int habitaciones_numeroHabitacion, @Param("atendida") Boolean atendida);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservaServicios WHERE habitaciones_numeroHabitacion =:habitaciones_numeroHabitacion", nativeQuery = true)
    void eliminarHabitacion(@Param("habitaciones_numeroHabitacion") int habitaciones_numeroHabitacion);
    
}
