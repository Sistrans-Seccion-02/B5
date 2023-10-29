package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ElementoExtra;

public interface ElementoExtraRepository extends JpaRepository<ElementoExtra, String>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO elementosExtras (nombreElemento) VALUES (:nombreElemento)", nativeQuery = true)
    void insertarElementoExtra(@Param("nombreElemento") String nombreElemento);

    @Query(value = "SELECT * FROM elementosExtras", nativeQuery = true)
    Collection<ElementoExtra> darElementosExtras();

    @Query(value = "SELECT * FROM elementosExtras WHERE nombreElemento = :nombreElemento", nativeQuery = true)
    ElementoExtra darElementoExtra(@Param("nombreElemento") String nombreElemento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE elementosExtras SET nombreElemento = :nombreElemento_actualizado"
        + " WHERE nombreElemento = :nombreElemento", nativeQuery = true)
    void actualizarElementoExtra(@Param("nombreElemento") String nombreElemento,
        @Param("nombreElemento_actualizado") String nombreElemento_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM elementosExtras WHERE nombreElemento = :nombreElemento", nativeQuery = true)
    void eliminarElementoExtra(@Param("nombreElemento") String nombreElemento);
}
