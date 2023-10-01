package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;

public interface PlanConsumoRepository extends JpaRepository<PlanConsumo, Integer>{
    
    @Query(value = "SELECT * FROM planesConsumo ", nativeQuery = true)
    Collection<TipoHabitacion> darPlanesdeConsumo();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planesConsumo (id, nombre, descripcion) VALUES(proyecto_sequence.nextval, :nombre, :descripcion) ", nativeQuery = true)
    void insertarPlandeConsumo(@Param("nombre") String nombre, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE planesConsumo SET nombre = :nombre, descripcion = :descripcion WHERE id = :id", nativeQuery = true)
    void actualizarPlandeConsumo(@Param("id") int id, @Param("nombre") String nombre, @Param("descripcion") String descripcion);



    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planesConsumo WHERE id =:id", nativeQuery = true)
    void eliminarPlandeConsumo(@Param("id") int id);
}
