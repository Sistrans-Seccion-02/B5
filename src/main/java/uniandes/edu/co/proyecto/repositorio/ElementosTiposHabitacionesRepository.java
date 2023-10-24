package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ElementosTiposHabitaciones;

public interface ElementosTiposHabitacionesRepository extends JpaRepository<ElementosTiposHabitaciones, String>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO elementosTiposHabitaciones (tipoHabitacion, nombreElemento)"
        + " VALUES (:tipoHabitacion, :nombreElemento)", nativeQuery = true)
    void insertarElementoTipoHabitacion(@Param("tipoHabitacion") String tipoHabitacion,
        @Param("nombreElemento") String nombreElemento);

    @Query(value = "SELECT * FROM elementosTiposHabitaciones", nativeQuery = true)
    Collection<ElementosTiposHabitaciones> darElementosTiposHabitaciones();

    @Query(value = "SELECT * FROM elementosTiposHabitaciones WHERE tipoHabitacion = :tipoHabitacion"
        + " AND nombreElemento = :nombreElemento", nativeQuery = true)
    ElementosTiposHabitaciones darElementoTipoHabitacion(@Param("tipoHabitacion") String tipoHabitacion,
        @Param("nombreElemento") String nombreElemento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE elementosTiposHabitaciones SET tipoHabitacion = :tipoHabitacion_actualizado,"
        + " nombreElemento = :nombreElemento_actualizado"
        + " WHERE tipoHabitacion = :tipoHabitacion AND nombreElemento = :nombreElemento", nativeQuery = true)
    void actualizarElementoTipoHabitacion(@Param("tipoHabitacion") String tipoHabitacion,
        @Param("nombreElemento") String nombreElemento,
        @Param("tipoHabitacion_actualizado") String tipoHabitacion_actualizado,
        @Param("nombreElemento_actualizado") String nombreElemento_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM elementosTiposHabitaciones WHERE tipoHabitacion = :tipoHabitacion"
        + " AND nombreElemento = :nombreElemento", nativeQuery = true)
    void eliminarElementoTipoHabitacion(@Param("tipoHabitacion") String tipoHabitacion,
        @Param("nombreElemento") String nombreElemento);
}
