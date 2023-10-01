package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String nombre;
    private Float cuentaCobro;
    private String tipoUsuario;

    public Usuario()
    {;}

    public Usuario(String nombre, String tipoUsuario, Float cuentaCobro)
    {
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
        this.cuentaCobro = cuentaCobro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Float getCuentaCobro() {
        return cuentaCobro;
    }

    public void setCuentaCobro(Float cuentaCobro) {
        this.cuentaCobro = cuentaCobro;
    }

    
}
