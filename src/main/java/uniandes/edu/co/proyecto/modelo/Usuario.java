package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String nombre;
    private String rol;
    private Float cuentaCobro;

    public Usuario(String nombre, String rol, Float cuentaCobro)
    {
        this.nombre = nombre;
        this.rol = rol;
        this.cuentaCobro = cuentaCobro;
    }

    public Usuario()
    {;}

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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Float getCuentaCobro() {
        return cuentaCobro;
    }

    public void setCuentaCobro(Float cuentaCobro) {
        this.cuentaCobro = cuentaCobro;
    }

    
}
