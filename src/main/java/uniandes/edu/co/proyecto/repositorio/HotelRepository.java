package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO hoteles (nombre) VALUES (:nombre)", nativeQuery = true)
    void insertarHotel(@Param("nombre") String nombre);

    @Query(value = "SELECT * FROM hoteles", nativeQuery = true)
    Collection<Hotel> darHoteles();

    @Query(value = "SELECT * FROM hoteles WHERE nombre = :nombre", nativeQuery = true)
    Hotel darHotel(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE hoteles SET nombre = :nombre_actualizado WHERE nombre = :nombre", nativeQuery = true)
    void actualizarHotel(@Param("nombre") String nombre, @Param("nombre_actualizado") String nombre_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hoteles WHERE nombre = :nombre", nativeQuery = true)
    void eliminarHotel(@Param("nombre") String nombre);
}
