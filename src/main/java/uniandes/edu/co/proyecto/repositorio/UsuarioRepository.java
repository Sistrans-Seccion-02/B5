package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.modelo.UsuarioPk;


public interface UsuarioRepository extends JpaRepository<Usuario, UsuarioPk>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (id, tipoId, nombre, tipoUsuario, correo, habitaciones_numeroHabitacion)"
    + " VALUES (:id, :tipoId, :nombre, :tipoUsuario, :correo, :habitaciones_numeroHabitacion)", nativeQuery = true)
    void insertarUsuario(@Param("id") Integer id, @Param("tipoId") String tipoId,
        @Param("nombre") String nombre, @Param("tipoUsuario") String tipoUsuario,
        @Param("correo") String correo,
        @Param("habitaciones_numeroHabitacion") Integer habitaciones_numeroHabitacion);

    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM usuarios WHERE id = :id AND tipoId = :tipoId", nativeQuery = true)
    Usuario darUsuario(@Param("id") Integer id, @Param("tipoId") String tipoId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET nombre = :nombre, tipoUsuario = :tipoUsuario,"
        + " correo = :correo, habitaciones_numeroHabitacion = :habitaciones_numeroHabitacion"
        + " WHERE id =:id AND tipoId = :tipoId",
        nativeQuery = true)
    void actualizarUsuario(@Param("id") Integer id,
        @Param("tipoId") String tipoId,
        @Param("nombre") String nombre, @Param("tipoUsuario") String tipoUsuario,
        @Param("correo") String correo,
        @Param("habitaciones_numeroHabitacion") Integer habitaciones_numeroHabitacion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE id = :id AND tipoId = :tipoId", nativeQuery = true)
    void eliminarUsuario(@Param("id") Integer id, @Param("tipoId") String tipoId);
}
