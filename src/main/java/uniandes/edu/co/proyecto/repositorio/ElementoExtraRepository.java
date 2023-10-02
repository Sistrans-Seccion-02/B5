package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ElementoExtra;

public interface ElementoExtraRepository extends JpaRepository<ElementoExtra, Integer>{

    @Query(value = "SELECT * FROM elementosExtras ", nativeQuery = true)
    Collection<ElementoExtra> darElementoExtras();

    @Query(value = "SELECT * FROM elementosExtras WHERE idElemento = :idElemento", nativeQuery = true)
    ElementoExtra darElementoExtra(@Param("idElemento") int idElemento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO elementosExtras (idElemento, nombreElemento, numeroHabitacion) VALUES(proyecto_sequence.nextval, :nombreElemento, :numeroHabitacion) ", nativeQuery = true)
    void insertarElementoExtra(@Param("nombreElemento") String nombreElemento, @Param("numeroHabitacion") int numeroHabitacion);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE elementosExtras SET nombreElemento= :nombreElemento, numeroHabitacion = :numeroHabitacion WHERE idElemento =:idElemento", nativeQuery = true)
    void actualizarElementoExtra(@Param("idElemento") int idElemento, @Param("nombreElemento") String nombre, @Param("numeroHabitacion") int numeroHabitacion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM elementosExtras WHERE idElemento =:idElemento", nativeQuery = true)
    void eliminarElementoExtra(@Param("idElemento") int idElemento);

    
}
