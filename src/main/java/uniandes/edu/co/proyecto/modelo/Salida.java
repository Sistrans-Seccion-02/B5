package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "salidas")
public class Salida {
    @Id
    @OneToOne
    @JoinColumn(name = "numreserva", referencedColumnName = "numreserva")
    private ReservaHoteles numreserva;
    private Float cuentatotal;

    public Salida(ReservaHoteles numreserva, Float cuentatotal) {
        this.numreserva = numreserva;
        this.cuentatotal = cuentatotal;
    }

    public Salida(){;}

    public ReservaHoteles getNumReserva() {
        return numreserva;
    }

    public void setNumReserva(ReservaHoteles numreserva) {
        this.numreserva = numreserva;
    }

    public Float getCuentaTotal() {
        return cuentatotal;
    }

    public void setCuentaTotal(Float cuentatotal) {
        this.cuentatotal = cuentatotal;
    }
}
