package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Promocion;

public interface PromocionRepository extends JpaRepository<Promocion, String>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO promociones (nombrePlan, descuentoAlojamiento, descuentoComida,"
        + " descuentoServicios, costo, diasMinimaEstadia)"
        + " VALUES (:nombrePlan, :descuentoAlojamiento, :descuentoComida, :descuentoServicios, :costo,"
        + " :diasMinimaEstadia)", nativeQuery = true)
    void insertarPromocion(@Param("nombrePlan") String nombrePlan,
        @Param("descuentoAlojamiento") Float descuentoAlojamiento,
        @Param("descuentoComida") Float descuentoComida,
        @Param("descuentoServicios") Float descuentoServicios,
        @Param("costo") Float costo,
        @Param("diasMinimaEstadia") Integer diasMinimaEstadia);

    @Query(value = "SELECT * FROM promociones", nativeQuery = true)
    Collection<Promocion> darPromociones();

    @Query(value = "SELECT * FROM promociones WHERE nombrePlan = :nombrePlan", nativeQuery = true)
    Promocion darPromocion(@Param("nombrePlan") String nombrePlan);

    @Modifying
    @Transactional
    @Query(value = "UPDATE promociones SET nombrePlan = :nombrePlan_actualizado, descuentoAlojamiento = :descuentoAlojamiento,"
        + " descuentoComida = :descuentoComida, descuentoServicios = :descuentoServicios, costo = :costo,"
        + " diasMinimaEstadia = :diasMinimaEstadia"
        + " WHERE nombrePlan = :nombrePlan", nativeQuery = true)
    void actualizarPromocion(@Param("nombrePlan") String nombrePlan,
        @Param("nombrePlan_actualizado") String nombrePlan_actualizado,
        @Param("descuentoAlojamiento") Float descuentoAlojamiento,
        @Param("descuentoComida") Float descuentoComida,
        @Param("descuentoServicios") Float descuentoServicios,
        @Param("costo") Float costo,
        @Param("diasMinimaEstadia") Integer diasMinimaEstadia);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM promociones WHERE nombrePlan = :nombrePlan", nativeQuery = true)
    void eliminarPromocion(@Param("nombrePlan") String nombrePlan);
}
