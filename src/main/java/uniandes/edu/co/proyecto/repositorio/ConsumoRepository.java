package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bar;
import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Gimnasio;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Internet;
import uniandes.edu.co.proyecto.modelo.Lavanderia;
import uniandes.edu.co.proyecto.modelo.Piscina;
import uniandes.edu.co.proyecto.modelo.PrestamoUtensilio;
import uniandes.edu.co.proyecto.modelo.Restaurante;
import uniandes.edu.co.proyecto.modelo.Salon;
import uniandes.edu.co.proyecto.modelo.Spa;
import uniandes.edu.co.proyecto.modelo.Supermercado;
import uniandes.edu.co.proyecto.modelo.Tienda;

public interface ConsumoRepository extends JpaRepository<Consumo, Integer>{

    //crud for consumo repositoy with operations similar to reservaServicios repository
    @Query(value = "SELECT * FROM consumos ", nativeQuery = true)
    Collection<Consumo> darConsumo();

    @Query(value = "SELECT * FROM consumos WHERE id = :id", nativeQuery = true)
    Consumo darConsumoPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumos (costo, cargadoHabitacion, fecha, gimnasios_idTipoServicio, salones_idTipoServicio, prestamos_idTipoServicio, supermercados_idTipoServicio, piscinas_idTipoServicio, tiendas_idTipoServicio, internet_idTipoServicio, bares_idTipoServicio, lavanderias_idTipoServicio, restaurantes_idTipoServicio, spas_idTipoServicio, habitaciones_numeroHabitacion) VALUES (:costo, :cargadoHabitacion, :fecha, :gimnasios_idTipoServicio, :salones_idTipoServicio, :prestamos_idTipoServicio, :supermercados_idTipoServicio, :piscinas_idTipoServicio, :tiendas_idTipoServicio, :internet_idTipoServicio, :bares_idTipoServicio, :lavanderias_idTipoServicio, :restaurantes_idTipoServicio, :spas_idTipoServicio, :habitaciones_numeroHabitacion)", nativeQuery = true)
    void crearConsumo(@Param("costo") Integer costo,
    @Param("cargadoHabitacion") Boolean cargadoHabitacion,
    @Param("fecha") java.sql.Date fecha,
    @Param("gimnasios_idTipoServicio") Gimnasio gimnasios_idTipoServicio,
    @Param("salones_idTipoServicio") Salon salones_idTipoServicio,
    @Param("prestamos_idTipoServicio") PrestamoUtensilio prestamos_idTipoServicio,
    @Param("supermercados_idTipoServicio") Supermercado supermercados_idTipoServicio,
    @Param("piscinas_idTipoServicio") Piscina piscinas_idTipoServicio,
    @Param("tiendas_idTipoServicio") Tienda tiendas_idTipoServicio,
    @Param("internet_idTipoServicio") Internet internet_idTipoServicio,
    @Param("bares_idTipoServicio") Bar bares_idTipoServicio,
    @Param("lavanderias_idTipoServicio") Lavanderia lavanderias_idTipoServicio,
    @Param("restaurantes_idTipoServicio") Restaurante restaurantes_idTipoServicio,
    @Param("spas_idTipoServicio") Spa spas_idTipoServicio,
    @Param("habitaciones_numeroHabitacion") Habitacion habitaciones_numeroHabitacion
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE consumos SET costo= :costo, cargadoHabitacion= :cargadoHabitacion, fecha= :fecha, gimnasios_idTipoServicio= :gimnasios_idTipoServicio, salones_idTipoServicio= :salones_idTipoServicio, prestamos_idTipoServicio= :prestamos_idTipoServicio, supermercados_idTipoServicio= :supermercados_idTipoServicio, piscinas_idTipoServicio= :piscinas_idTipoServicio, tiendas_idTipoServicio= :tiendas_idTipoServicio, internet_idTipoServicio= :internet_idTipoServicio, bares_idTipoServicio= :bares_idTipoServicio, lavanderias_idTipoServicio= :lavanderias_idTipoServicio, restaurantes_idTipoServicio= :restaurantes_idTipoServicio, spas_idTipoServicio= :spas_idTipoServicio, habitaciones_numeroHabitacion= :habitaciones_numeroHabitacion WHERE id =:id", nativeQuery = true)
    void actualizarConsumo(@Param("costo") Integer costo,
    @Param("cargadoHabitacion") Boolean cargadoHabitacion,
    @Param("fecha") java.sql.Date fecha,
    @Param("gimnasios_idTipoServicio") Gimnasio gimnasios_idTipoServicio,
    @Param("salones_idTipoServicio") Salon salones_idTipoServicio,
    @Param("prestamos_idTipoServicio") PrestamoUtensilio prestamos_idTipoServicio,
    @Param("supermercados_idTipoServicio") Supermercado supermercados_idTipoServicio,
    @Param("piscinas_idTipoServicio") Piscina piscinas_idTipoServicio,
    @Param("tiendas_idTipoServicio") Tienda tiendas_idTipoServicio,
    @Param("internet_idTipoServicio") Internet internet_idTipoServicio,
    @Param("bares_idTipoServicio") Bar bares_idTipoServicio,
    @Param("lavanderias_idTipoServicio") Lavanderia lavanderias_idTipoServicio,
    @Param("restaurantes_idTipoServicio") Restaurante restaurantes_idTipoServicio,
    @Param("spas_idTipoServicio") Spa spas_idTipoServicio,
    @Param("habitaciones_numeroHabitacion") Habitacion habitaciones_numeroHabitacion,
    @Param("id") Integer id
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE id = :id", nativeQuery = true)
    void eliminarConsumo(@Param("id") int id);

    //delete where habitaciones_numeroHabitacion = :habitaciones_numeroHabitacion
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE habitaciones_numeroHabitacion = :habitaciones_numeroHabitacion", nativeQuery = true)
    void eliminarConsumoPorHabitacion(@Param("habitaciones_numeroHabitacion") Habitacion habitaciones_numeroHabitacion);

}
