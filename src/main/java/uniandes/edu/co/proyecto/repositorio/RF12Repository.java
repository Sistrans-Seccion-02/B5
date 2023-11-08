package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumo;

public interface RF12Repository extends JpaRepository<Consumo, Integer> {

    @Query(value = "SELECT u.* FROM usuarios u WHERE EXISTS (SELECT * FROM reservaservicios rs WHERE rs.habitaciones_numeroHabitacion = u.habitaciones_numeroHabitacion " +//
    
    "GROUP BY YEAR(rs.fecha), QUARTER(rs.fecha) HAVING COUNT(DISTINCT rs.fecha) >= 1) OR EXISTS (SELECT * FROM consumo c " +//
    
    "WHERE c.habitaciones_numeroHabitacion = u.habitaciones_numeroHabitacion AND c.costo > 300000) OR EXISTS ( " +//
    
    "SELECT * FROM reservaservicios rs JOIN consumo c ON rs.habitaciones_numeroHabitacion = c.habitaciones_numeroHabitacion " +//
    
    "WHERE rs.habitaciones_numeroHabitacion = u.habitaciones_numeroHabitacion AND (rs.spas_idTipoServicio IS NOT NULL OR rs.salones_idTipoServicio IS NOT NULL) " +//
    
    "AND c.fecha BETWEEN rs.fecha AND DATE_ADD(rs.fecha, INTERVAL 4 HOUR) ); " , nativeQuery = true)
    Collection<Object[]> darRespuesta();
    
}
