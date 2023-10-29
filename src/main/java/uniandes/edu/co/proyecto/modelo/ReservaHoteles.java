package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservashoteles")
public class ReservaHoteles {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer numreserva;
    private Date fechaentrada;
    private Date fechasalida;
    private Boolean pago;
    private Boolean reservatomada;
    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hotel hoteles_nombre;
    @ManyToOne
    @JoinColumn(name = "habitaciones_numeroHabitacion", referencedColumnName = "numerohabitacion")
    private Habitacion habitaciones_numerohabitacion;
    @ManyToOne(optional = true)
    @JoinColumn(name = "promociones_nombreplan", referencedColumnName = "nombreplan")
    private Promocion promociones_nombreplan;

    public ReservaHoteles(Date fechaentrada, Date fechasalida, Boolean pago, Boolean reservatomada,
            Hotel hoteles_nombre, Habitacion habitaciones_numerohabitacion, Promocion promociones_nombreplan) {
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
        this.pago = pago;
        this.reservatomada = reservatomada;
        this.hoteles_nombre = hoteles_nombre;
        this.habitaciones_numerohabitacion = habitaciones_numerohabitacion;
        this.promociones_nombreplan = promociones_nombreplan;
    }

    public ReservaHoteles(){;}

    public Integer getNumReserva() {
        return numreserva;
    }

    public void setNumReserva(Integer numreserva) {
        this.numreserva = numreserva;
    }

    public Date getFechaEntrada() {
        return fechaentrada;
    }

    public void setFechaEntrada(Date fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public Date getFechaSalida() {
        return fechasalida;
    }

    public void setFechaSalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Boolean getReservaTomada() {
        return reservatomada;
    }

    public void setReservaTomada(Boolean reservatomada) {
        this.reservatomada = reservatomada;
    }

    public Hotel getHoteles_nombre() {
        return hoteles_nombre;
    }

    public void setHoteles_nombre(Hotel hoteles_nombre) {
        this.hoteles_nombre = hoteles_nombre;
    }

    public Habitacion getHabitaciones_numeroHabitacion() {
        return habitaciones_numerohabitacion;
    }

    public void setHabitaciones_numeroHabitacion(Habitacion habitaciones_numerohabitacion) {
        this.habitaciones_numerohabitacion = habitaciones_numerohabitacion;
    }

    public Promocion getPromociones_nombrePlan() {
        return promociones_nombreplan;
    }

    public void setPromociones_nombrePlan(Promocion promociones_nombreplan) {
        this.promociones_nombreplan = promociones_nombreplan;
    }
}
