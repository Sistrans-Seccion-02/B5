package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Promocion;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface PromocionRepository extends JpaRepository<Promocion, Integer>{

    @Query(value = "SELECT * FROM promociones ", nativeQuery = true)
    Collection<Usuario> darPromocion();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO promociones (nombrePlan, descuentoAlojamiento, descuentoComidas, descuentoServicios, costo, diasMinimaEstadia) VALUES(:nombrePlan, :descuentoAlojamiento, :descuentoComidas, :descuentoServicios, :costo, :diasMinimaEstadia) ", nativeQuery = true)
    void insertarPromocion(@Param("nombrePlan") String nombrePlan,@Param("descuentoAlojamiento") Double descuentoAlojamiento,@Param("descuentoComidas") Double descuentoComidas,
    @Param("descuentoServicios") Double descuentoServicios,@Param("costo") Double costo,@Param("diasMinimaEstadia") String diasMinimaEstadia);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE promociones SET descuentoAlojamiento= :descuentoAlojamiento,descuentoComidas= :descuentoComidas,descuentoServicios= :descuentoServicios,costo= :costo,diasMinimaEstadia= :diasMinimaEstadia WHERE nombrePlan =:nombrePlan", nativeQuery = true)
    void actualizarPromocion(@Param("nombrePlan") String nombrePlan,@Param("descuentoAlojamiento") Double descuentoAlojamiento,@Param("descuentoComidas") Double descuentoComidas,
    @Param("descuentoServicios") Double descuentoServicios,@Param("costo") Double costo,@Param("diasMinimaEstadia") String diasMinimaEstadia);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM promociones WHERE nombrePlan =:nombrePlan", nativeQuery = true)
    void eliminarPromocion(@Param("nombrePlan") int nombrePlan);
    
}
