package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    @OneToOne(optional = true)
    @JoinColumn(name = "promociones_nombrePlan", referencedColumnName = "nombrePlan")
    private Promocion promociones_nombrePlan;
    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hotel hoteles_nombre;
    @ManyToOne
    @JoinColumn(name = "habitacioes_numero_habitacion", referencedColumnName = "numeroHabitacion")
    private Habitacion habitacioes_numero_habitacion;

    public ReservaHoteles()
    {;}

    public ReservaHoteles(Date fechaEntrada, Date fechaSalida, Boolean pago, Boolean reservaTomada,
            Promocion promociones_nombrePlan, Hotel hoteles_nombre, Habitacion habitacioes_numero_habitacion) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.pago = pago;
        this.reservaTomada = reservaTomada;
        this.promociones_nombrePlan = promociones_nombrePlan;
        this.hoteles_nombre = hoteles_nombre;
        this.habitacioes_numero_habitacion = habitacioes_numero_habitacion;
    }

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

    public Promocion getPromociones_nombrePlan() {
        return promociones_nombrePlan;
    }

    public void setPromociones_nombrePlan(Promocion promociones_nombrePlan) {
        this.promociones_nombrePlan = promociones_nombrePlan;
    }

    public Hotel getHoteles_nombre() {
        return hoteles_nombre;
    }

    public void setHoteles_nombre(Hotel hoteles_nombre) {
        this.hoteles_nombre = hoteles_nombre;
    }

    public Habitacion getHabitacioes_numero_habitacion() {
        return habitacioes_numero_habitacion;
    }

    public void setHabitacioes_numero_habitacion(Habitacion habitacioes_numero_habitacion) {
        this.habitacioes_numero_habitacion = habitacioes_numero_habitacion;
    }
}
