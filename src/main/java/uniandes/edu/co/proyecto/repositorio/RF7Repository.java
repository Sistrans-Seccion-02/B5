package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumo;

public interface RF7Repository extends JpaRepository<Consumo, Integer> {

    @Query(value = "SELECT u.nombre AS NombreCliente, u.pk AS IdentificacionCliente FROM usuarios u " +//
    "LEFT JOIN reservasServicios rs ON u.pk = rs.habitaciones_numeroHabitacion " +//

    "LEFT JOIN consumos c ON rs.habitaciones_numeroHabitacion = c.habitaciones_numeroHabitacion " +//

    "WHERE (DATEDIFF(CURRENT_DATE, rs.fecha) >= 14 OR EXISTS ( SELECT SUM(costo) FROM consumos " +//
        
    "WHERE  habitaciones_numeroHabitacion = u.pk AND fecha BETWEEN DATE_SUB(CURRENT_DATE, INTERVAL 1 YEAR) AND CURRENT_DATE " +//

    "GROUP BY habitaciones_numeroHabitacion HAVING SUM(costo) > 15000000 ) ) GROUP BY u.pk ", nativeQuery = true)
    Collection<Object[]> darCliente();
    
}
