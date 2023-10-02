package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumo;

public interface ConsumoRepository extends JpaRepository<Consumo, Integer>{

    @Query(value = "SELECT * FROM consumos ", nativeQuery = true)
    Collection<Consumo> darConsumos();

    @Query(value = "SELECT * FROM consumos WHERE id = :id", nativeQuery = true)
    Consumo darConsumo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumos (id, costo, barId, numeroHabitacion, internetId, piscinaId, numReserva, restauranteId, salonId, spaId, supermercadoId, tiendaId) VALUES(proyecto_sequence.nextval, :estilo, :costo, :barId, :numeroHabitacion, :internetId, :piscinaId, :numReserva, :restauranteId, :salonId, :spaId, :supermercadoId, :tiendaId) ", nativeQuery = true)
    void insertarConsumo(@Param("costo") int costo,@Param("barId") int barId, @Param("numeroHabitacion") int numeroHabitacion, @Param("internetId") int internetId, @Param("piscinaId") int piscinaId, @Param("numReserva") int numReserva,@Param("restauranteId") int restauranteId,@Param("salonId") int salonId, @Param("spaId") int spaId, @Param("supermercadoId") int supermercadoId, @Param("tiendaId") int tiendaId );
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE consumos SET costo= :costo, barId= :barId, numeroHabitacion= :numeroHabitacion, internetId= :internetId, piscinaId= :piscinaId, numReserva= :numReserva, restauranteId= :restauranteId, salonId= :salonId, spaId= :spaId, supermercadoId= :supermercadoId, tiendaId= :tiendaId  WHERE id =:id", nativeQuery = true)
    void actualizarConsumo(@Param("id") int id,@Param("costo") int costo,@Param("barId") int barId, @Param("numeroHabitacion") int numeroHabitacion, @Param("internetId") int internetId, @Param("piscinaId") int piscinaId, @Param("numReserva") int numReserva,@Param("restauranteId") int restauranteId,@Param("salonId") int salonId, @Param("spaId") int spaId, @Param("supermercadoId") int supermercadoId, @Param("tiendaId") int tiendaId);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE id =:id", nativeQuery = true)
    void eliminarConsumo(@Param("id") int id);
    
}
