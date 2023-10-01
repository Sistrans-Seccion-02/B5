package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservasServicios")
public class ReservaServicios {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer numReserva;
    private Date fecha;
    private Boolean atendida;
    @ManyToOne
    @JoinColumn(name = "habitaciones_numeroHabitacion", referencedColumnName = "numeroHabitacion")
    private Habitacion habitaciones_numeroHabitacion;
    @ManyToOne(optional = true)
    @JoinColumn(name = "lavanderias_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Lavanderia lavanderias_idTipoServicio;
    @ManyToOne(optional = true)
    @JoinColumn(name = "bares_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Bar bares_idTipoServicio;
    @ManyToOne(optional = true)
    @JoinColumn(name = "spas_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Spa spas_idTipoServicio;
    @ManyToOne(optional = true)
    @JoinColumn(name = "gimnasio_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Gimnasio gimnasio_idTipoServicio;
    @ManyToOne(optional = true)
    @JoinColumn(name = "salon_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Salon salon_idTipoServicio;
    @ManyToOne(optional = true)
    @JoinColumn(name = "restaurante_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Restaurante restaurante_idTipoServicio;
    @ManyToOne(optional = true)
    @JoinColumn(name = "piscina_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Piscina piscina_idTipoServicio;

    public ReservaServicios()
    {;}

    public ReservaServicios(Date fecha, Boolean atendida, Habitacion habitaciones_numeroHabitacion,
            Lavanderia lavanderias_idTipoServicio, Bar bares_idTipoServicio, Spa spas_idTipoServicio,
            Gimnasio gimnasio_idTipoServicio, Salon salon_idTipoServicio, Restaurante restaurante_idTipoServicio,
            Piscina piscina_idTipoServicio) {
        this.fecha = fecha;
        this.atendida = atendida;
        this.habitaciones_numeroHabitacion = habitaciones_numeroHabitacion;
        this.lavanderias_idTipoServicio = lavanderias_idTipoServicio;
        this.bares_idTipoServicio = bares_idTipoServicio;
        this.spas_idTipoServicio = spas_idTipoServicio;
        this.gimnasio_idTipoServicio = gimnasio_idTipoServicio;
        this.salon_idTipoServicio = salon_idTipoServicio;
        this.restaurante_idTipoServicio = restaurante_idTipoServicio;
        this.piscina_idTipoServicio = piscina_idTipoServicio;
    }

    public Integer getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(Integer numReserva) {
        this.numReserva = numReserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getAtendida() {
        return atendida;
    }

    public void setAtendida(Boolean atendida) {
        this.atendida = atendida;
    }

    public Habitacion getHabitaciones_numeroHabitacion() {
        return habitaciones_numeroHabitacion;
    }

    public void setHabitaciones_numeroHabitacion(Habitacion habitaciones_numeroHabitacion) {
        this.habitaciones_numeroHabitacion = habitaciones_numeroHabitacion;
    }

    public Lavanderia getLavanderias_idTipoServicio() {
        return lavanderias_idTipoServicio;
    }

    public void setLavanderias_idTipoServicio(Lavanderia lavanderias_idTipoServicio) {
        this.lavanderias_idTipoServicio = lavanderias_idTipoServicio;
    }

    public Bar getBares_idTipoServicio() {
        return bares_idTipoServicio;
    }

    public void setBares_idTipoServicio(Bar bares_idTipoServicio) {
        this.bares_idTipoServicio = bares_idTipoServicio;
    }

    public Spa getSpas_idTipoServicio() {
        return spas_idTipoServicio;
    }

    public void setSpas_idTipoServicio(Spa spas_idTipoServicio) {
        this.spas_idTipoServicio = spas_idTipoServicio;
    }

    public Gimnasio getGimnasio_idTipoServicio() {
        return gimnasio_idTipoServicio;
    }

    public void setGimnasio_idTipoServicio(Gimnasio gimnasio_idTipoServicio) {
        this.gimnasio_idTipoServicio = gimnasio_idTipoServicio;
    }

    public Salon getSalon_idTipoServicio() {
        return salon_idTipoServicio;
    }

    public void setSalon_idTipoServicio(Salon salon_idTipoServicio) {
        this.salon_idTipoServicio = salon_idTipoServicio;
    }

    public Restaurante getRestaurante_idTipoServicio() {
        return restaurante_idTipoServicio;
    }

    public void setRestaurante_idTipoServicio(Restaurante restaurante_idTipoServicio) {
        this.restaurante_idTipoServicio = restaurante_idTipoServicio;
    }

    public Piscina getPiscina_idTipoServicio() {
        return piscina_idTipoServicio;
    }

    public void setPiscina_idTipoServicio(Piscina piscina_idTipoServicio) {
        this.piscina_idTipoServicio = piscina_idTipoServicio;
    }
}
