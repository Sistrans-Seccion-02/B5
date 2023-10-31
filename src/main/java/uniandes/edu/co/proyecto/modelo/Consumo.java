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
    private Integer gimnasios_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "salones_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer salones_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "prestamos_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer prestamos_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "supermercados_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer supermercados_idTipoServicio;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "piscinas_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer piscinas_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "tiendas_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer tiendas_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "internet_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer internet_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "bares_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer bares_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "lavanderias_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer lavanderias_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "restaurantes_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer restaurantes_idTipoServicio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "spas_idTipoServicio", referencedColumnName = "idTipoServicio")
    private Integer spas_idTipoServicio;

    @ManyToOne
    @JoinColumn(name = "habitaciones_numeroHabitacion", referencedColumnName = "numeroHabitacion")
    private Integer habitaciones_numeroHabitacion;
    
    
    
    public Consumo(Integer costo, Boolean cargadoHabitacion , Date fecha, Integer gimnasios_idTipoServicio,
            Integer salones_idTipoServicio, Integer prestamos_idTipoServicio,
            Integer supermercados_idTipoServicio, Integer piscinas_idTipoServicio,
            Integer tiendas_idTipoServicio, Integer internet_idTipoServicio, Integer bares_idTipoServicio,
            Integer lavanderias_idTipoServicio, Integer restaurantes_idTipoServicio, Integer spas_idTipoServicio,
            Integer habitaciones_numeroHabitacion) {

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


    public Boolean isCargadoHabitacion() {
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


    public Integer getPrestamos_idTipoServicio() {
        return prestamos_idTipoServicio;
    }


    public void setPrestamos_idTipoServicio(Integer prestamos_idTipoServicio) {
        this.prestamos_idTipoServicio = prestamos_idTipoServicio;
    }


    public Integer getSupermercados_idTipoServicio() {
        return supermercados_idTipoServicio;
    }


    public void setSupermercados_idTipoServicio(Integer supermercados_idTipoServicio) {
        this.supermercados_idTipoServicio = supermercados_idTipoServicio;
    }


    public Integer getPiscinas_idTipoServicio() {
        return piscinas_idTipoServicio;
    }


    public void setPiscinas_idTipoServicio(Integer piscinas_idTipoServicio) {
        this.piscinas_idTipoServicio = piscinas_idTipoServicio;
    }


    public Integer getTiendas_idTipoServicio() {
        return tiendas_idTipoServicio;
    }


    public void setTiendas_idTipoServicio(Integer tiendas_idTipoServicio) {
        this.tiendas_idTipoServicio = tiendas_idTipoServicio;
    }


    public Integer getInternet_idTipoServicio() {
        return internet_idTipoServicio;
    }


    public void setInternet_idTipoServicio(Integer internet_idTipoServicio) {
        this.internet_idTipoServicio = internet_idTipoServicio;
    }


    public Integer getBares_idTipoServicio() {
        return bares_idTipoServicio;
    }


    public void setBares_idTipoServicio(Integer bares_idTipoServicio) {
        this.bares_idTipoServicio = bares_idTipoServicio;
    }


    public Integer getLavanderias_idTipoServicio() {
        return lavanderias_idTipoServicio;
    }


    public void setLavanderias_idTipoServicio(Integer lavanderias_idTipoServicio) {
        this.lavanderias_idTipoServicio = lavanderias_idTipoServicio;
    }


    public Integer getRestaurantes_idTipoServicio() {
        return restaurantes_idTipoServicio;
    }


    public void setRestaurantes_idTipoServicio(Integer restaurantes_idTipoServicio) {
        this.restaurantes_idTipoServicio = restaurantes_idTipoServicio;
    }


    public Integer getSpas_idTipoServicio() {
        return spas_idTipoServicio;
    }


    public void setSpas_idTipoServicio(Integer spas_idTipoServicio) {
        this.spas_idTipoServicio = spas_idTipoServicio;
    }


    public Integer getHabitaciones_numeroHabitacion() {
        return habitaciones_numeroHabitacion;
    }


    public void setHabitaciones_numeroHabitacion(Integer habitaciones_numeroHabitacion) {
        this.habitaciones_numeroHabitacion = habitaciones_numeroHabitacion;
    }

    

    


    

}
