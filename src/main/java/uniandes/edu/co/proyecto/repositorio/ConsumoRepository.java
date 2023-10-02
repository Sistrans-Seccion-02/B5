package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumo;

public interface ConsumoRepository extends JpaRepository<Consumo, Integer>{

    @Query(value = "SELECT * FROM bares ", nativeQuery = true)
    Collection<Consumo> darConsumos();

    @Query(value = "SELECT * FROM bares WHERE idTipoServicio = :idTipoServicio", nativeQuery = true)
    Consumo darConsumo(@Param("idTipoServicio") int idTipoServicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bares (idTipoServicio, estilo, aforo, aplicaCompartido) VALUES(proyecto_sequence.nextval, :estilo, :aforo, :aplicaCompartido) ", nativeQuery = true)
    void insertarConsumo(@Param("estilo") String estilo, @Param("aforo") int aforo, @Param("aplicaCompartido") Boolean aplicaCompartido);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE bares SET estilo= :estilo, aforo= :aforo, aplicaCompartido= :aplicaCompartido WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void actualizarConsumo(@Param("idTipoServicio") int idTipoServicio,@Param("estilo") String estilo, @Param("aforo") int aforo, @Param("aplicaCompartido") Boolean aplicaCompartido);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bares WHERE idTipoServicio =:idTipoServicio", nativeQuery = true)
    void eliminarConsumo(@Param("idTipoServicio") int idTipoServicio);
    
}
