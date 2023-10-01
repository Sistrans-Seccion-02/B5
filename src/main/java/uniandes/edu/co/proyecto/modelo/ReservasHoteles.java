package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservasHoteles")
public class ReservasHoteles {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer numReserva;

    private Date fechaEntrada;
    private Date fechaSalida;
    private Boolean pago;
    private Boolean reservaTomada;

    public ReservasHoteles(Date fechaEntrada, Date fechaSalida, Boolean pago, Boolean reservaTomada)
    {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.pago = pago;
        this.reservaTomada = reservaTomada;
    }

    public ReservasHoteles()
    {;}

    public Integer getNumReserva() {
        return numReserva;
    }


    public void setNumReserva(Integer numReserva) {
        this.numReserva = numReserva;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Boolean getReservaTomada() {
        return reservaTomada;
    }

    public void setReservaTomada(Boolean reservaTomada) {
        this.reservaTomada = reservaTomada;
    }

    
}
