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

    @ManyToOne
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    private TipoUsuario tipo;

    public Usuario()
    {;}

    public Usuario(String nombre, TipoUsuario tipo, Float cuentaCobro)
    {
        this.nombre = nombre;
        this.tipo = tipo;
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

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public Float getCuentaCobro() {
        return cuentaCobro;
    }

    public void setCuentaCobro(Float cuentaCobro) {
        this.cuentaCobro = cuentaCobro;
    }

    
}
