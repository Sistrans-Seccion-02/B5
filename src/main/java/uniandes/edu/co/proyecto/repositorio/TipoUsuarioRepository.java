package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {

    @Query(value = "SELECT * FROM tipoUsuarios ", nativeQuery = true)
    Collection<TipoUsuario> darTiposdeUsuarios();

    //Revisar que sea proyecto o proyecto1
    //modifying sirve para avisar que vamos a alterar las instancias de las tablas
    //Transactional para decir que lo vamos a tratar como una transacción
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tipoUsuarios (id, nombre) VALUES(proyecto_sequence.nextval, :nombre) ", nativeQuery = true)
    void insertarTipoUsuario(@Param("nombre") String nombre);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE tipoUsuarios SET nombre= :nombre WHERE id =:id", nativeQuery = true)
    void actualizarTipoUsuario(@Param("id") int id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tipoUsuarios WHERE id =:id", nativeQuery = true)
    void eliminarTipoUsuario(@Param("id") int id);

    
}
