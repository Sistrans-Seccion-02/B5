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
@Table(name = "consumos")
public class Consumo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private Integer costo;
    private Boolean cargadoHabitacion;
    private Date fecha;

    @ManyToOne(optional = true)
    @JoinColumn(name = "gimnasios_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Gimnasio gimnasios_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "salones_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Salon salones_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "prestamos_idTipoServicio", referencedColumnName = "idTipoServicio")
    private PrestamoUtensilio prestamos_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "supermercados_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Supermercado supermercados_idTipoServicio;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "piscinas_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Piscina piscinas_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "tiendas_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Tienda tiendas_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "internet_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Internet internet_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "bares_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Bar bares_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "lavanderias_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Lavanderia lavanderias_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "restaurantes_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Restaurante restaurantes_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "spas_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Spa spas_idTipoServicio;

    @ManyToOne
    @JoinColumn(name = "habitaciones_numeroHabitacion", referencedColumnName = "numeroHabitacion")
    private Habitacion habitaciones_numeroHabitacion;
    
    
    
    public Consumo(Integer costo, Boolean cargadoHabitacion , Date fecha, Gimnasio gimnasios_idTipoServicio,
            Salon salones_idTipoServicio, PrestamoUtensilio prestamos_idTipoServicio,
            Supermercado supermercados_idTipoServicio, Piscina piscinas_idTipoServicio,
            Tienda tiendas_idTipoServicio, Internet internet_idTipoServicio, Bar bares_idTipoServicio,
            Lavanderia lavanderias_idTipoServicio, Restaurante restaurantes_idTipoServicio, Spa spas_idTipoServicio,
            Habitacion habitaciones_numeroHabitacion) {

        this.costo = costo;
        this.cargadoHabitacion = cargadoHabitacion;
        this.fecha = fecha;
        this.gimnasios_idTipoServicio = gimnasios_idTipoServicio;
        this.salones_idTipoServicio = salones_idTipoServicio;
        this.prestamos_idTipoServicio = prestamos_idTipoServicio;
        this.supermercados_idTipoServicio = supermercados_idTipoServicio;
        this.piscinas_idTipoServicio = piscinas_idTipoServicio;
        this.tiendas_idTipoServicio = tiendas_idTipoServicio;
        this.internet_idTipoServicio = internet_idTipoServicio;
        this.bares_idTipoServicio = bares_idTipoServicio;
        this.lavanderias_idTipoServicio = lavanderias_idTipoServicio;
        this.restaurantes_idTipoServicio = restaurantes_idTipoServicio;
        this.spas_idTipoServicio = spas_idTipoServicio;
        this.habitaciones_numeroHabitacion = habitaciones_numeroHabitacion;
    }
    

    public Consumo()
    {;}


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getCosto() {
        return costo;
    }


    public void setCosto(Integer costo) {
        this.costo = costo;
    }


    public boolean isCargadoHabitacion() {
        return cargadoHabitacion;
    }


    public void setCargadoHabitacion(Boolean cargadoHabitacion) {
        this.cargadoHabitacion = cargadoHabitacion;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Gimnasio getGimnasios_idTipoServicio() {
        return gimnasios_idTipoServicio;
    }


    public void setGimnasios_idTipoServicio(Gimnasio gimnasios_idTipoServicio) {
        this.gimnasios_idTipoServicio = gimnasios_idTipoServicio;
    }


    public Salon getSalones_idTipoServicio() {
        return salones_idTipoServicio;
    }


    public void setSalones_idTipoServicio(Salon salones_idTipoServicio) {
        this.salones_idTipoServicio = salones_idTipoServicio;
    }


    public PrestamoUtensilio getPrestamos_idTipoServicio() {
        return prestamos_idTipoServicio;
    }


    public void setPrestamos_idTipoServicio(PrestamoUtensilio prestamos_idTipoServicio) {
        this.prestamos_idTipoServicio = prestamos_idTipoServicio;
    }


    public Supermercado getSupermercados_idTipoServicio() {
        return supermercados_idTipoServicio;
    }


    public void setSupermercados_idTipoServicio(Supermercado supermercados_idTipoServicio) {
        this.supermercados_idTipoServicio = supermercados_idTipoServicio;
    }


    public Piscina getPiscinas_idTipoServicio() {
        return piscinas_idTipoServicio;
    }


    public void setPiscinas_idTipoServicio(Piscina piscinas_idTipoServicio) {
        this.piscinas_idTipoServicio = piscinas_idTipoServicio;
    }


    public Tienda getTiendas_idTipoServicio() {
        return tiendas_idTipoServicio;
    }


    public void setTiendas_idTipoServicio(Tienda tiendas_idTipoServicio) {
        this.tiendas_idTipoServicio = tiendas_idTipoServicio;
    }


    public Internet getInternet_idTipoServicio() {
        return internet_idTipoServicio;
    }


    public void setInternet_idTipoServicio(Internet internet_idTipoServicio) {
        this.internet_idTipoServicio = internet_idTipoServicio;
    }


    public Bar getBares_idTipoServicio() {
        return bares_idTipoServicio;
    }


    public void setBares_idTipoServicio(Bar bares_idTipoServicio) {
        this.bares_idTipoServicio = bares_idTipoServicio;
    }


    public Lavanderia getLavanderias_idTipoServicio() {
        return lavanderias_idTipoServicio;
    }


    public void setLavanderias_idTipoServicio(Lavanderia lavanderias_idTipoServicio) {
        this.lavanderias_idTipoServicio = lavanderias_idTipoServicio;
    }


    public Restaurante getRestaurantes_idTipoServicio() {
        return restaurantes_idTipoServicio;
    }


    public void setRestaurantes_idTipoServicio(Restaurante restaurantes_idTipoServicio) {
        this.restaurantes_idTipoServicio = restaurantes_idTipoServicio;
    }


    public Spa getSpas_idTipoServicio() {
        return spas_idTipoServicio;
    }


    public void setSpas_idTipoServicio(Spa spas_idTipoServicio) {
        this.spas_idTipoServicio = spas_idTipoServicio;
    }


    public Habitacion getHabitaciones_numeroHabitacion() {
        return habitaciones_numeroHabitacion;
    }


    public void setHabitaciones_numeroHabitacion(Habitacion habitaciones_numeroHabitacion) {
        this.habitaciones_numeroHabitacion = habitaciones_numeroHabitacion;
    }

    

    


    

}
