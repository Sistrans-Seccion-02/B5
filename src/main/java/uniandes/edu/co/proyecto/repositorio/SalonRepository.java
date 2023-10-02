package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Salon;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface SalonRepository extends JpaRepository<Salon, Integer>{

    @Query(value = "SELECT * FROM salones ", nativeQuery = true)
    Collection<Usuario> darSalones();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO salones (idTipoServicio, aforo, equipo, aplicaCompartido, hoteles_nombre) VALUES(:idTipoServicio, :aforo, :equipo, :aplicaCompartido, :hoteles_nombre) ", nativeQuery = true)
    void insertarSalon(@Param("aforo") Integer aforo, @Param("equipo") Integer equipo, @Param("aplicaCompartido") Integer aplicaCompartido, @Param("hoteles_nombre") String hoteles_nombre);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE salones SET aforo= :aforo, equipo= :equipo, aplicaCompartido= :aplicaCompartido, hoteles_nombre= :hoteles_nombre WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void actualizarSalon(@Param("idTipoServicio") int idTipoServicio, @Param("aforo") Integer aforo, @Param("equipo") Integer equipo, @Param("aplicaCompartido") Integer aplicaCompartido, @Param("hoteles_nombre") String hoteles_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM salones WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarSalon(@Param("idTipoServicio") int idTipoServicio);
    
}
