package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumo;

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
    @Param("gimnasios_idTipoServicio") Integer gimnasios_idTipoServicio,
    @Param("salones_idTipoServicio") Integer salones_idTipoServicio,
    @Param("prestamos_idTipoServicio") Integer prestamos_idTipoServicio,
    @Param("supermercados_idTipoServicio") Integer supermercados_idTipoServicio,
    @Param("piscinas_idTipoServicio") Integer piscinas_idTipoServicio,
    @Param("tiendas_idTipoServicio") Integer tiendas_idTipoServicio,
    @Param("internet_idTipoServicio") Integer internet_idTipoServicio,
    @Param("bares_idTipoServicio") Integer bares_idTipoServicio,
    @Param("lavanderias_idTipoServicio") Integer lavanderias_idTipoServicio,
    @Param("restaurantes_idTipoServicio") Integer restaurantes_idTipoServicio,
    @Param("spas_idTipoServicio") Integer spas_idTipoServicio,
    @Param("habitaciones_numeroHabitacion") Integer habitaciones_numeroHabitacion
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE consumos SET costo= :costo, cargadoHabitacion= :cargadoHabitacion, fecha= :fecha, gimnasios_idTipoServicio= :gimnasios_idTipoServicio, salones_idTipoServicio= :salones_idTipoServicio, prestamos_idTipoServicio= :prestamos_idTipoServicio, supermercados_idTipoServicio= :supermercados_idTipoServicio, piscinas_idTipoServicio= :piscinas_idTipoServicio, tiendas_idTipoServicio= :tiendas_idTipoServicio, internet_idTipoServicio= :internet_idTipoServicio, bares_idTipoServicio= :bares_idTipoServicio, lavanderias_idTipoServicio= :lavanderias_idTipoServicio, restaurantes_idTipoServicio= :restaurantes_idTipoServicio, spas_idTipoServicio= :spas_idTipoServicio, habitaciones_numeroHabitacion= :habitaciones_numeroHabitacion WHERE id =:id", nativeQuery = true)
    void actualizarConsumo(@Param("costo") Integer costo,
    @Param("cargadoHabitacion") Boolean cargadoHabitacion,
    @Param("fecha") java.sql.Date fecha,
    @Param("gimnasios_idTipoServicio") Integer gimnasios_idTipoServicio,
    @Param("salones_idTipoServicio") Integer salones_idTipoServicio,
    @Param("prestamos_idTipoServicio") Integer prestamos_idTipoServicio,
    @Param("supermercados_idTipoServicio") Integer supermercados_idTipoServicio,
    @Param("piscinas_idTipoServicio") Integer piscinas_idTipoServicio,
    @Param("tiendas_idTipoServicio") Integer tiendas_idTipoServicio,
    @Param("internet_idTipoServicio") Integer internet_idTipoServicio,
    @Param("bares_idTipoServicio") Integer bares_idTipoServicio,
    @Param("lavanderias_idTipoServicio") Integer lavanderias_idTipoServicio,
    @Param("restaurantes_idTipoServicio") Integer restaurantes_idTipoServicio,
    @Param("spas_idTipoServicio") Integer spas_idTipoServicio,
    @Param("habitaciones_numeroHabitacion") Integer habitaciones_numeroHabitacion,
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
    void eliminarConsumoPorHabitacion(@Param("habitaciones_numeroHabitacion") int habitaciones_numeroHabitacion);

}
