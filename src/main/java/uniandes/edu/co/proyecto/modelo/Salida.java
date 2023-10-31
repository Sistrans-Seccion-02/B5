package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "salidas")
public class Salida {
    @EmbeddedId
    private SalidaPk pk;
    private Float cuentatotal;

    public Salida(ReservaHoteles numreserva, Float cuentatotal) {
        this.pk = new SalidaPk(numreserva);
        this.cuentatotal = cuentatotal;
    }

    public Salida(){;}

    public SalidaPk getPk() {
        return pk;
    }

    public void setPk(SalidaPk pk) {
        this.pk = pk;
    }

    public Float getCuentatotal() {
        return cuentatotal;
    }

    public void setCuentatotal(Float cuentatotal) {
        this.cuentatotal = cuentatotal;
    }
}
