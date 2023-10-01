package uniandes.edu.co.proyecto.modelo;

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
    @ManyToOne
    @JoinColumn(name="BarId", referencedColumnName="idTipoServicio")
    private Bar barId;
    @ManyToOne
    @JoinColumn(name="NumeroHabitacion", referencedColumnName="numeroHabitacion")
    private Habitacion numeroHabitacion;

    @ManyToOne
    @JoinColumn(name="InternetId", referencedColumnName="idTipoServicio")
    private Internet internetId;
    
    @ManyToOne
    @JoinColumn(name="PiscinaId", referencedColumnName="idTipoServicio")
    private Piscina piscinaId;
    
    @ManyToOne
    @JoinColumn(name="numReserva", referencedColumnName="numReserva")
    private ReservaServicios numReserva;
    
    @ManyToOne
    @JoinColumn(name="RestauranteId", referencedColumnName="idTipoServicio")
    private Restaurante restauranteId;
    
    @ManyToOne
    @JoinColumn(name="SalonId", referencedColumnName="idTipoServicio")
    private Salon salonId;

    @ManyToOne
    @JoinColumn(name="SpaId", referencedColumnName="idTipoServicio")
    private Spa spaId;

    @ManyToOne
    @JoinColumn(name="SupermercadoId", referencedColumnName="idTipoServicio")
    private Supermercado supermercadoId;

    @ManyToOne
    @JoinColumn(name="TiendaId", referencedColumnName="idTipoServicio")
    private Tienda tiendaId;
    
    
    
    public Consumo(Integer costo, Habitacion numeroHabitacion, Bar barId, Internet internetId, Piscina piscinaId, ReservaServicios numReserva, Restaurante restauranteId, Salon salonId, Spa spaId, Supermercado supermercadoId, Tienda tiendaId)
    {
        this.costo = costo;
        this.numeroHabitacion = numeroHabitacion;
        this.barId = barId;
        this.internetId = internetId;
        this.piscinaId = piscinaId;
        this.numReserva = numReserva;
        this.restauranteId = restauranteId;
        this.salonId = salonId;
        this.spaId = spaId;
        this.supermercadoId = supermercadoId;
        this.tiendaId = tiendaId;
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


    public Bar getBarId() {
        return barId;
    }


    public void setBarId(Bar barId) {
        this.barId = barId;
    }


    public Habitacion getNumeroHabitacion() {
        return numeroHabitacion;
    }


    public void setNumeroHabitacion(Habitacion numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }


    public Internet getInternetId() {
        return internetId;
    }


    public void setInternetId(Internet internetId) {
        this.internetId = internetId;
    }


    public Piscina getPiscinaId() {
        return piscinaId;
    }


    public void setPiscinaId(Piscina piscinaId) {
        this.piscinaId = piscinaId;
    }


    public ReservaServicios getNumReserva() {
        return numReserva;
    }


    public void setNumReserva(ReservaServicios numReserva) {
        this.numReserva = numReserva;
    }


    public Restaurante getRestauranteId() {
        return restauranteId;
    }


    public void setRestauranteId(Restaurante restauranteId) {
        this.restauranteId = restauranteId;
    }


    public Salon getSalonId() {
        return salonId;
    }


    public void setSalonId(Salon salonId) {
        this.salonId = salonId;
    }


    public Spa getSpaId() {
        return spaId;
    }


    public void setSpaId(Spa spaId) {
        this.spaId = spaId;
    }


    public Supermercado getSupermercadoId() {
        return supermercadoId;
    }


    public void setSupermercadoId(Supermercado supermercadoId) {
        this.supermercadoId = supermercadoId;
    }


    public Tienda getTiendaId() {
        return tiendaId;
    }


    public void setTiendaId(Tienda tiendaId) {
        this.tiendaId = tiendaId;
    }

    


    

}
