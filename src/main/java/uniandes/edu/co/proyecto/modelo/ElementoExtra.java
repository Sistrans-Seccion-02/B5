package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "elementosextras")
public class ElementoExtra {
    @Id
    private String nombreelemento;

    public ElementoExtra(String nombreelemento) {
        this.nombreelemento = nombreelemento;
    }

    public ElementoExtra(){;}

    public String getNombreElemento() {
        return nombreelemento;
    }

    public void setNombreElemento(String nombreElemento) {
        this.nombreelemento = nombreElemento;
    }
}