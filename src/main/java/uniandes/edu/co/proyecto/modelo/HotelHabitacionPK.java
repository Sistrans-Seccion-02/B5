package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class HotelHabitacionPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="id_bebedor",referencedColumnName = "id")
    private Hotel id_hotel;
    @ManyToOne
    @JoinColumn(name="id_habitacion",referencedColumnName = "numeroHabitacion")
    private Habitacion id_habitacion;

    public HotelHabitacionPK(Hotel id_hotel, Habitacion id_habitacion) {
        super();
        this.id_hotel = id_hotel;
        this.id_habitacion = id_habitacion;
    }

    public Hotel getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(Hotel id_hotel) {
        this.id_hotel = id_hotel;
    }

    public Habitacion getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(Habitacion id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    

    
    
}
