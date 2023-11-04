package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.Salon;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface SalonRepository extends JpaRepository<Salon, Integer>{

    @Query(value = "SELECT * FROM salones ", nativeQuery = true)
    Collection<Usuario> darSalones();

    @Query(value = "SELECT * FROM salones WHERE idTipoServicio = :idTipoServicio", nativeQuery = true)
    Salon darSalon(@Param("idTipoServicio") int idTipoServicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO salones (idTipoServicio, aforo, equipo, aplicaCompartido, nombreHotel) VALUES(salonesSeq.nextval, :aforo, :equipo, :aplicaCompartido, :nombreHotel) ", nativeQuery = true)
    void insertarSalon(@Param("aforo") Integer aforo, @Param("equipo") String equipo, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") Hotel nombreHotel);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE salones SET aforo= :aforo, equipo= :equipo, aplicaCompartido= :aplicaCompartido, nombreHotel= :nombreHotel WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void actualizarSalon(@Param("idTipoServicio") int idTipoServicio, @Param("aforo") Integer aforo, @Param("equipo") String equipo, @Param("aplicaCompartido") Boolean aplicaCompartido, @Param("nombreHotel") Hotel nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM salones WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarSalon(@Param("idTipoServicio") int idTipoServicio);
    
}
