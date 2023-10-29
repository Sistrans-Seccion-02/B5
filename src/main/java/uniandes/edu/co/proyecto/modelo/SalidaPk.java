package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class SalidaPk implements Serializable{
    @OneToOne
    @JoinColumn(name = "numreserva", referencedColumnName = "numreserva")
    private ReservaHoteles numreserva;

    public SalidaPk(ReservaHoteles numreserva){
        super();
        this.numreserva = numreserva;
    }

    public SalidaPk(){;}

    public ReservaHoteles getNumreserva() {
        return numreserva;
    }

    public void setNumreserva(ReservaHoteles numreserva) {
        this.numreserva = numreserva;
    }
}
