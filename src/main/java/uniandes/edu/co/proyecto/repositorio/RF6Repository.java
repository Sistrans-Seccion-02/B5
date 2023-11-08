package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumo;

public interface RF6Repository extends JpaRepository<Consumo, Integer> {

    @Query(value = "SELECT TOP 1 fechaentrada AS Fecha, COUNT(*) AS Total_Habitaciones_Ocupadas  FROM reservashoteles " + //
    " GROUP BY fechaentrada  ORDER BY Total_Habitaciones_Ocupadas DESC LIMIT 1; ", nativeQuery = true)
    Object[] darMayorOcupacion(); 

    @Query(value = "SELECT TOP 1 fecha AS Fecha, SUM(costo) AS Total_Ingresos  FROM consumos  GROUP BY fecha"  +//   
    "ORDER BY Total_Ingresos DESC LIMIT 1; ", nativeQuery = true )
                    Object[] darIngreso();

    @Query(value = "SELECT TOP 1 fechaentrada AS Fecha, COUNT(*) AS Total_Habitaciones_Ocupadas FROM reservashoteles" +//  
    "GROUP BY fechaentrada  ORDER BY Total_Habitaciones_Ocupadas ASC " , nativeQuery = true )
                        Object[] darMenorOcupacion();
    
}
