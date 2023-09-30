package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer numReserva;
    private Integer numPersonas;

    public Reserva(Integer numPersonas)
    {
        this.numPersonas = numPersonas;
    }

    public Reserva()
    {;}

    public Integer getNumReserva() {
        return numReserva;
    }

    public Integer getNumPersonas() {
        return numPersonas;
    }

    public void setNumReserva(Integer numReserva) {
        this.numReserva = numReserva;
    }

    public void setNumPersonas(Integer numPersonas) {
        this.numPersonas = numPersonas;
    }
}
