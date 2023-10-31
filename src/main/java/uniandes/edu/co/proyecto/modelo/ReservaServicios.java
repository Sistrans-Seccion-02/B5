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
@Table(name = "reservasServicios")
public class ReservaServicios {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer numReserva;
    private Date fecha;
    private Boolean atendida;
    @ManyToOne
    @JoinColumn(name = "habitaciones_numeroHabitacion", referencedColumnName = "numeroHabitacion")
    private Integer habitaciones_numeroHabitacion;
    @ManyToOne(optional = true)
    @JoinColumn(name = "lavanderias_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer lavanderias_idTipoServicio;
    @ManyToOne(optional = true)
    @JoinColumn(name = "bares_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer bares_idTipoServicio;
    @ManyToOne(optional = true)
    @JoinColumn(name = "spas_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer spas_idTipoServicio;
    @ManyToOne(optional = true)
    @JoinColumn(name = "gimnasios_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer gimnasios_idTipoServicio;
    @ManyToOne(optional = true)
    @JoinColumn(name = "salones_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer salones_idTipoServicio;
    @ManyToOne(optional = true)
    @JoinColumn(name = "restaurantes_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer restaurantes_idTipoServicio;
    @ManyToOne(optional = true)
    @JoinColumn(name = "piscinas_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer piscinas_idTipoServicio;

    public ReservaServicios()
    {;}

    public ReservaServicios(Date fecha, Boolean atendida, Integer habitaciones_numeroHabitacion,
            Integer lavanderias_idTipoServicio, Integer bares_idTipoServicio, Integer spas_idTipoServicio,
            Integer gimnasios_idTipoServicio, Integer salones_idTipoServicio, Integer restaurantes_idTipoServicio,
            Integer piscinas_idTipoServicio) {
        this.fecha = fecha;
        this.atendida = atendida;
        this.habitaciones_numeroHabitacion = habitaciones_numeroHabitacion;
        this.lavanderias_idTipoServicio = lavanderias_idTipoServicio;
        this.bares_idTipoServicio = bares_idTipoServicio;
        this.spas_idTipoServicio = spas_idTipoServicio;
        this.gimnasios_idTipoServicio = gimnasios_idTipoServicio;
        this.salones_idTipoServicio = salones_idTipoServicio;
        this.restaurantes_idTipoServicio = restaurantes_idTipoServicio;
        this.piscinas_idTipoServicio = piscinas_idTipoServicio;
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

    public Integer getHabitaciones_numeroHabitacion() {
        return habitaciones_numeroHabitacion;
    }

    public void setHabitaciones_numeroHabitacion(Integer habitaciones_numeroHabitacion) {
        this.habitaciones_numeroHabitacion = habitaciones_numeroHabitacion;
    }

    public Integer getLavanderias_idTipoServicio() {
        return lavanderias_idTipoServicio;
    }

    public void setLavanderias_idTipoServicio(Integer lavanderias_idTipoServicio) {
        this.lavanderias_idTipoServicio = lavanderias_idTipoServicio;
    }

    public Integer getBares_idTipoServicio() {
        return bares_idTipoServicio;
    }

    public void setBares_idTipoServicio(Integer bares_idTipoServicio) {
        this.bares_idTipoServicio = bares_idTipoServicio;
    }

    public Integer getSpas_idTipoServicio() {
        return spas_idTipoServicio;
    }

    public void setSpas_idTipoServicio(Integer spas_idTipoServicio) {
        this.spas_idTipoServicio = spas_idTipoServicio;
    }

    public Integer getGimnasios_idTipoServicio() {
        return gimnasios_idTipoServicio;
    }

    public void setGimnasios_idTipoServicio(Integer gimnasios_idTipoServicio) {
        this.gimnasios_idTipoServicio = gimnasios_idTipoServicio;
    }

    public Integer getSalones_idTipoServicio() {
        return salones_idTipoServicio;
    }

    public void setSalones_idTipoServicio(Integer salones_idTipoServicio) {
        this.salones_idTipoServicio = salones_idTipoServicio;
    }

    public Integer getRestaurantes_idTipoServicio() {
        return restaurantes_idTipoServicio;
    }

    public void setRestaurantes_idTipoServicio(Integer restaurantes_idTipoServicio) {
        this.restaurantes_idTipoServicio = restaurantes_idTipoServicio;
    }

    public Integer getPiscinas_idTipoServicio() {
        return piscinas_idTipoServicio;
    }

    public void setPiscinas_idTipoServicio(Integer piscinas_idTipoServicio) {
        this.piscinas_idTipoServicio = piscinas_idTipoServicio;
    }
}
