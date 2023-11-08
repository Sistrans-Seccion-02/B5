package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumo;

public interface RF9Repository extends JpaRepository<Consumo, Integer> {

    @Query(value = "SELECT u.nombre AS NombreCliente, u.correo AS CorreoCliente, rs.fecha AS FechaReserva, COUNT(rs.numReserva) AS VecesConsumido " +//

    "FROM Usuario u JOIN ReservaServicios rs ON u.id = rs.idUsuario  WHERE rs.idservicio= idtiposervicio AND rs.fecha BETWEEN 'FechaInicio' AND 'FechaFin' " +//

    "GROUP BY u.id, rs.fecha  ORDER BY  NombreCliente ASC, VecesConsumido DESC " , nativeQuery = true)
    Collection<Object[]> darRespuesta();
    
}
