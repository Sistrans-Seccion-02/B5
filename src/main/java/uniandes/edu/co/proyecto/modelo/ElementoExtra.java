package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "elementosExtras")
public class ElementoExtra {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idElemento;
    private String nombreElemento;

    public ElementoExtra(String nombreElemento)
    {
        this.nombreElemento = nombreElemento;
    }

    public ElementoExtra()
    {;}

    public Integer getIdElemento() {
        return idElemento;
    }

    public String getNombreElemento() {
        return nombreElemento;
    }

    public void setIdElemento(Integer idElemento) {
        this.idElemento = idElemento;
    }

    public void setNombreElemento(String nombreElemento) {
        this.nombreElemento = nombreElemento;
    }
}