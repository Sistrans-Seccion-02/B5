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
@Table(name = "reservasHoteles")
public class ReservaHoteles {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer numReserva;
    private Date fechaEntrada;
    private Date fechaSalida;
    private Boolean pago;
    private Boolean reservaTomada;
    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hotel hoteles_nombre;
    @ManyToOne
    @JoinColumn(name = "habitaciones_numeroHabitacion", referencedColumnName = "numeroHabitacion")
    private Habitacion habitaciones_numeroHabitacion;
    @ManyToOne(optional = true)
    @JoinColumn(name = "promociones_nombrePlan", referencedColumnName = "nombrePlan")
    private Promocion promociones_nombrePlan;

    public ReservaHoteles(Date fechaEntrada, Date fechaSalida, Boolean pago, Boolean reservaTomada,
            Hotel hoteles_nombre, Habitacion habitaciones_numeroHabitacion, Promocion promociones_nombrePlan) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.pago = pago;
        this.reservaTomada = reservaTomada;
        this.hoteles_nombre = hoteles_nombre;
        this.habitaciones_numeroHabitacion = habitaciones_numeroHabitacion;
        this.promociones_nombrePlan = promociones_nombrePlan;
    }

    public ReservaHoteles(){;}

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

    public Hotel getHoteles_nombre() {
        return hoteles_nombre;
    }

    public void setHoteles_nombre(Hotel hoteles_nombre) {
        this.hoteles_nombre = hoteles_nombre;
    }

    public Habitacion getHabitaciones_numeroHabitacion() {
        return habitaciones_numeroHabitacion;
    }

    public void setHabitaciones_numeroHabitacion(Habitacion habitaciones_numeroHabitacion) {
        this.habitaciones_numeroHabitacion = habitaciones_numeroHabitacion;
    }

    public Promocion getPromociones_nombrePlan() {
        return promociones_nombrePlan;
    }

    public void setPromociones_nombrePlan(Promocion promociones_nombrePlan) {
        this.promociones_nombrePlan = promociones_nombrePlan;
    }
}
