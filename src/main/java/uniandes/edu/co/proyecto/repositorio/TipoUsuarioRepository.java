package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, String>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiposUsuarios (tipoUsuario)"
        + " VALUES (:tipoUsuario)", nativeQuery = true)
    void insertarTipoUsuario(@Param("tipoUsuario") String tipoUsuario);

    @Query(value = "SELECT * FROM tiposUsuarios", nativeQuery = true)
    Collection<TipoUsuario> darTiposUsuario();

    @Query(value = "SELECT * FROM tiposUsuarios WHERE tipoUsuario = :tipoUsuario", nativeQuery = true)
    TipoUsuario darTipoUsuario(@Param("tipoUsuario") String tipoUsuario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tiposUsuarios SET tipoUsuario = :tipoUsuario_actualizado"
        + " WHERE tipoUsuario = :tipoUsuario", nativeQuery = true)
    void actualizarTipoUsuario(@Param("tipoUsuario") String tipoUsuario,
        @Param("tipoUsuario_actualizado") String tipoUsuario_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiposUsuarios WHERE tipoUsuario = :tipoUsuario", nativeQuery = true)
    void eliminarTipoUsuario(@Param("tipoUsuario") String tipoUsuario);
}
