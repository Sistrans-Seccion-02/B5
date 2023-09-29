package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

    @Query(value = "SELECT * FROM hoteles ", nativeQuery = true)
    Collection<Hotel> darHoteles();
    
}
