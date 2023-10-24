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
    @JoinColumn(name = "numReserva", referencedColumnName = "numReserva")
    private ReservaHoteles numReserva;
    private Float cuentaTotal;

    public Salida(ReservaHoteles numReserva, Float cuentaTotal) {
        this.numReserva = numReserva;
        this.cuentaTotal = cuentaTotal;
    }

    public Salida(){;}

    public ReservaHoteles getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(ReservaHoteles numReserva) {
        this.numReserva = numReserva;
    }

    public Float getCuentaTotal() {
        return cuentaTotal;
    }

    public void setCuentaTotal(Float cuentaTotal) {
        this.cuentaTotal = cuentaTotal;
    }
}
