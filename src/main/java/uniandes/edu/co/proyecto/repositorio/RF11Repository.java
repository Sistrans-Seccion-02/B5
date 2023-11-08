package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.Consumo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RF11Repository extends JpaRepository<Consumo, Integer>{

    @Query(value = "SELECT  YEAR(rs.fecha) AS Anio, ROUND(DATEDIFF(rs.fecha, DATEADD(DD, -3, rs.fecha))/7, 0) AS NumeroSemana, " +//

    "rs.servicio AS ServicioMasConsumido, rs.habitaciones_numeroHabitacion AS HabitacionMasSolicitada, ( SELECT TOP 1 servicio " +// 

    "FROM ReservaServicios WHERE rs.fecha BETWEEN fechaInicio AND fechaFin GROUP BY servicio ORDER BY COUNT(*) ASC ) AS ServicioMenosConsumido, " +//

    "(SELECT TOP 1 habitaciones_numeroHabitacion FROM ReservaServicios  WHERE rs.fecha BETWEEN fechaInicio AND fechaFin  " +//

    "GROUP BY habitaciones_numeroHabitacion ORDER BY COUNT(*) ASC) AS HabitacionMenosSolicitada FROM ReservaServicios rs " +//

    "GROUP BY YEAR(rs.fecha), ROUND(DATEDIFF(rs.fecha, DATEADD(DD, -3, rs.fecha))/7, 0), rs.servicio, rs.habitaciones_numeroHabitacion " +//

    "ORDER BY YEAR(rs.fecha), NumeroSemana; " , nativeQuery = true)
    Collection<Object[]> darRespuesta();
    
}
