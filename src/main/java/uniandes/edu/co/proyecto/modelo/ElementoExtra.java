package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "elementosExtras")
public class ElementoExtra {
    @Id
    private String nombreElemento;

    public ElementoExtra(String nombreElemento) {
        this.nombreElemento = nombreElemento;
    }

    public ElementoExtra(){;}

    public String getNombreElemento() {
        return nombreElemento;
    }

    public void setNombreElemento(String nombreElemento) {
        this.nombreElemento = nombreElemento;
    }
}