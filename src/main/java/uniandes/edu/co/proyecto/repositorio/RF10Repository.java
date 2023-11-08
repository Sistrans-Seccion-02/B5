package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumo;

public interface RF10Repository extends JpaRepository<Consumo, Integer> {

    @Query(value = "SELECT u.id AS IDCliente, u.nombre AS NombreCliente, rs.fecha AS FechaReserva, COUNT(rs.numReserva) AS VecesConsumido " +//

    "FROM Usuario u CROSS JOIN ReservaServicios rs WHERE u.id NOT IN ( SELECT u.id FROM Usuario u JOIN ReservaServicios rs ON u.id = rs.idUsuario " +//
    
    "WHERE rs.idservicio= idtiposervicio AND rs.fecha BETWEEN 'FechaInicio' AND 'FechaFin' ) AND rs.fecha BETWEEN 'FechaInicio' AND 'FechaFin' " +//
    
    "GROUP BY u.id, u.nombre, u.correo, rs.fecha  ORDER BY NombreCliente ASC, FechaReserva DESC " , nativeQuery = true)
    Collection<Object[]> darRespuesta();
    
}
