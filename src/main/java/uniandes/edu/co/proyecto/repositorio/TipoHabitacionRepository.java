package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;

public interface TipoHabitacionRepository  extends JpaRepository<TipoHabitacion, Integer>{

    @Query(value = "SELECT * FROM tipoHabitaciones ", nativeQuery = true)
    Collection<TipoHabitacion> darTipodeHabitaciones();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tipoHabitaciones (id, nombre, dotacion, costo) VALUES(proyecto_sequence.nextval, :nombre, :dotacion, :costo) ", nativeQuery = true)
    void insertarTipoHabitacion(@Param("nombre") String nombre, @Param("dotacion") String dotacion , @Param("costo") Integer costo);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE tipoHabitaciones SET nombre = :nombre, dotacion = :dotacion, costo = :costo WHERE id = :id", nativeQuery = true)
    void actualizarTipoHabitacion(@Param("id") int id, @Param("nombre") String nombre, @Param("dotacion") String dotacion, @Param("costo") Integer costo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tipoHabitaciones WHERE id =:id", nativeQuery = true)
    void eliminarTipoHabitacion(@Param("id") int id);



}
