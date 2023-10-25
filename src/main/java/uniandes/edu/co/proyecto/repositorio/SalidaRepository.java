package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Salida;

public interface SalidaRepository extends JpaRepository<Salida, Integer>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO salidas (numReserva, cuentaTotal)"
        + " VALUES (:numReserva, :cuentaTotal)", nativeQuery = true)
    void insertarSalida(@Param("numReserva") Integer numReserva,
        @Param("cuentaTotal") Float cuentaTotal);

    @Query(value = "SELECT * FROM salidas", nativeQuery = true)
    Collection<Salida> darSalidas();

    @Query(value = "SELECT * FROM salidas WHERE numReserva = :numReserva", nativeQuery = true)
    Salida darSalida(@Param("numReserva") Integer numReserva);

    @Modifying
    @Transactional
    @Query(value = "UPDATE salidas SET numReserva = :numReserva_actualizada, cuentaTotal = :cuentaTotal"
        + " WHERE numReserva = :numReserva", nativeQuery = true)
    void actualizarSalida(@Param("numReserva") Integer numReserva, @Param("cuentaTotal") Float cuentaTotal,
        @Param("numReserva_actualizada") Float numReserva_actualizada);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM salidas WHERE numReserva = :numReserva", nativeQuery = true)
    void eliminarSalida(@Param("numReserva") Integer numReserva);
}
