package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    @Query(value = "SELECT * FROM usuarios ", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM usuarios WHERE id = :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (id, nombre, cuentaCobro) VALUES(proyecto_sequence.nextval, :nombre, :cuentaCobro) ", nativeQuery = true)
    void insertarUsuario(@Param("nombre") String nombre, @Param("cuentaCobro") Float cuentaCobro);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET nombre= :nombre, cuentaCobro = :cuentaCobro WHERE id =:id", nativeQuery = true)
    void actualizarUsuario(@Param("id") int id, @Param("nombre") String nombre, @Param("cuentaCobro") Float cuentaCobro);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE id =:id", nativeQuery = true)
    void eliminarUsuario(@Param("id") int id);

    
}
