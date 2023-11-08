package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumo;

public interface RF8Repository extends JpaRepository<Consumo, Integer>{

    @Query(value = "SELECT rs.idTipoServicio, COUNT(*) AS VecesSolicitado, AVG(cast(DATEDIFF(CURRENT_DATE, rs.fecha) AS SIGNED) / 7) AS FrecuenciaSemanal "+//

    "FROM reservasServicios rs WHERE rs.fecha BETWEEN DATE_SUB(CURRENT_DATE, INTERVAL 1 YEAR) AND CURRENT_DATE "+//

    "GROUP BY rs.idTipoServicio HAVING FrecuenciaSemanal < 3 " , nativeQuery = true)
    Collection<Object[]> darRespuesta();
    
}
