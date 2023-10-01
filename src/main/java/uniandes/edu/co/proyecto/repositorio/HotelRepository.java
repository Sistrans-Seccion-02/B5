package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

    @Query(value = "SELECT * FROM hoteles ", nativeQuery = true)
    Collection<Hotel> darHoteles();

     @Modifying
    @Transactional
    @Query(value = "INSERT INTO hoteles (nombre) VALUES(:nombre) ", nativeQuery = true)
    void insertarHotel(@Param("nombre") String nombre);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE hoteles SET nombre= :nombre WHERE nombre =:nombre", nativeQuery = true)
    void actualizarHotel(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hoteles WHERE nombre =:nombre", nativeQuery = true)
    void eliminarHotel(@Param("nombre") String nombre);
    
}
