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
    private Boolean cargadohabitacion;
    private Date fecha;

    @ManyToOne(optional = true)
    @JoinColumn(name = "gimnasios_idtiposervicio", referencedColumnName = "idtiposervicio")
    private Gimnasio gimnasios_idtiposervicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "salones_idtiposervicio", referencedColumnName = "idtiposervicio")
    private Salon salones_idtiposervicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "prestamos_idtiposervicio", referencedColumnName = "idtiposervicio")
    private PrestamoUtensilio prestamos_idtiposervicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "supermercados_idtiposervicio", referencedColumnName = "idtiposervicio")
    private Supermercado supermercados_idtiposervicio;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "piscinas_idtiposervicio", referencedColumnName = "idtiposervicio")
    private Piscina piscinas_idtiposervicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "tiendas_idtiposervicio", referencedColumnName = "idtiposervicio")
    private Tienda tiendas_idtiposervicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "internet_idtiposervicio", referencedColumnName = "idtiposervicio")
    private Internet internet_idtiposervicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "bares_idtiposervicio", referencedColumnName = "idtiposervicio")
    private Bar bares_idtiposervicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "lavanderias_idtiposervicio", referencedColumnName = "idtiposervicio")
    private Lavanderia lavanderias_idtiposervicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "restaurantes_idtiposervicio", referencedColumnName = "idtiposervicio")
    private Restaurante restaurantes_idtiposervicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "spas_idtiposervicio", referencedColumnName = "idtiposervicio")
    private Spa spas_idtiposervicio;

    @ManyToOne
    @JoinColumn(name = "habitaciones_numerohabitacion", referencedColumnName = "numerohabitacion")
    private Habitacion numerohabitacion;
    
    
    
    public Consumo(Integer costo, Boolean cargadohabitacion , Date fecha, Gimnasio gimnasios_idtiposervicio,
            Salon salones_idtiposervicio, PrestamoUtensilio prestamos_idtiposervicio,
            Supermercado supermercados_idtiposervicio, Piscina piscinas_idtiposervicio,
            Tienda tiendas_idtiposervicio, Internet internet_idtiposervicio, Bar bares_idtiposervicio,
            Lavanderia lavanderias_idtiposervicio, Restaurante restaurantes_idtiposervicio, Spa spas_idtiposervicio,
            Habitacion numerohabitacion) {

        this.costo = costo;
        this.cargadohabitacion = cargadohabitacion;
        this.fecha = fecha;
        this.gimnasios_idtiposervicio = gimnasios_idtiposervicio;
        this.salones_idtiposervicio = salones_idtiposervicio;
        this.prestamos_idtiposervicio = prestamos_idtiposervicio;
        this.supermercados_idtiposervicio = supermercados_idtiposervicio;
        this.piscinas_idtiposervicio = piscinas_idtiposervicio;
        this.tiendas_idtiposervicio = tiendas_idtiposervicio;
        this.internet_idtiposervicio = internet_idtiposervicio;
        this.bares_idtiposervicio = bares_idtiposervicio;
        this.lavanderias_idtiposervicio = lavanderias_idtiposervicio;
        this.restaurantes_idtiposervicio = restaurantes_idtiposervicio;
        this.spas_idtiposervicio = spas_idtiposervicio;
        this.numerohabitacion = numerohabitacion;
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


    public Boolean iscargadoHabitacion() {
        return cargadohabitacion;
    }


    public void setcargadoHabitacion(Boolean cargadohabitacion) {
        this.cargadohabitacion = cargadohabitacion;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Gimnasio getGimnasios_idtiposervicio() {
        return gimnasios_idtiposervicio;
    }


    public void setGimnasios_idtiposervicio(Gimnasio gimnasios_idtiposervicio) {
        this.gimnasios_idtiposervicio = gimnasios_idtiposervicio;
    }


    public Salon getSalones_idtiposervicio() {
        return salones_idtiposervicio;
    }


    public void setSalones_idtiposervicio(Salon salones_idtiposervicio) {
        this.salones_idtiposervicio = salones_idtiposervicio;
    }


    public PrestamoUtensilio getPrestamos_idtiposervicio() {
        return prestamos_idtiposervicio;
    }


    public void setPrestamos_idtiposervicio(PrestamoUtensilio prestamos_idtiposervicio) {
        this.prestamos_idtiposervicio = prestamos_idtiposervicio;
    }


    public Supermercado getSupermercados_idtiposervicio() {
        return supermercados_idtiposervicio;
    }


    public void setSupermercados_idtiposervicio(Supermercado supermercados_idtiposervicio) {
        this.supermercados_idtiposervicio = supermercados_idtiposervicio;
    }


    public Piscina getPiscinas_idtiposervicio() {
        return piscinas_idtiposervicio;
    }


    public void setPiscinas_idtiposervicio(Piscina piscinas_idtiposervicio) {
        this.piscinas_idtiposervicio = piscinas_idtiposervicio;
    }


    public Tienda getTiendas_idtiposervicio() {
        return tiendas_idtiposervicio;
    }


    public void setTiendas_idtiposervicio(Tienda tiendas_idtiposervicio) {
        this.tiendas_idtiposervicio = tiendas_idtiposervicio;
    }


    public Internet getInternet_idtiposervicio() {
        return internet_idtiposervicio;
    }


    public void setInternet_idtiposervicio(Internet internet_idtiposervicio) {
        this.internet_idtiposervicio = internet_idtiposervicio;
    }


    public Bar getBares_idtiposervicio() {
        return bares_idtiposervicio;
    }


    public void setBares_idtiposervicio(Bar bares_idtiposervicio) {
        this.bares_idtiposervicio = bares_idtiposervicio;
    }


    public Lavanderia getLavanderias_idtiposervicio() {
        return lavanderias_idtiposervicio;
    }


    public void setLavanderias_idtiposervicio(Lavanderia lavanderias_idtiposervicio) {
        this.lavanderias_idtiposervicio = lavanderias_idtiposervicio;
    }


    public Restaurante getRestaurantes_idtiposervicio() {
        return restaurantes_idtiposervicio;
    }


    public void setRestaurantes_idtiposervicio(Restaurante restaurantes_idtiposervicio) {
        this.restaurantes_idtiposervicio = restaurantes_idtiposervicio;
    }


    public Spa getSpas_idtiposervicio() {
        return spas_idtiposervicio;
    }


    public void setSpas_idtiposervicio(Spa spas_idtiposervicio) {
        this.spas_idtiposervicio = spas_idtiposervicio;
    }


    public Habitacion getHabitaciones_numeroHabitacion() {
        return numerohabitacion;
    }


    public void setHabitaciones_numeroHabitacion(Habitacion numerohabitacion) {
        this.numerohabitacion = numerohabitacion;
    }

    

    


    

}
