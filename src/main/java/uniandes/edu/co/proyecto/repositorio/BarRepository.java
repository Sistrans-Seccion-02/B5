package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bar;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface BarRepository extends JpaRepository<Bar, Integer>{

    @Query(value = "SELECT * FROM bares ", nativeQuery = true)
    Collection<Bar> darBares();

    @Query(value = "SELECT * FROM bares WHERE id = :id", nativeQuery = true)
        Usuario darBar(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bares (numeroHabitacion, disponibilidad) VALUES(proyecto_sequence.nextval, :disponibilidad) ", nativeQuery = true)
    void insertarBar(@Param("disponibilidad") Boolean disponibilidad);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE bares SET disponibilidad= :disponibilidad WHERE numeroHabitacion =:numeroHabitacion", nativeQuery = true)
    void actualizarBar(@Param("numeroHabitacion") int numeroHabitacion, @Param("disponibilidad") Boolean disponibilidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bares WHERE numeroHabitacion =:numeroHabitacion", nativeQuery = true)
    void eliminarBar(@Param("numeroHabitacion") int numeroHabitacion);
    
}
