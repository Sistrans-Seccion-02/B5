package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumo;

public interface RF5Repository extends JpaRepository<Consumo, Integer>{
    
    @Query(value = "SELECT u.id, u.nombre, s.fecha FROM Usuarios u  INNER JOIN ReservaServicios s ON u. habitaciones_numerohabitacion " + //   
     "= s. habitaciones_numerohabitacion WHERE u.id = ID_DEL_USUARIO AND s.Fecha >= 'FECHA_DE_INICIO'  AND s.Fecha <= 'FECHA_DE_FIN' " + //   
    "ORDER BY s.fecha; ", nativeQuery = true ) Collection<Object[]> darConsumos();
                   
}
