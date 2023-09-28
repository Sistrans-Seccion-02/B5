package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotelHabitaciones")
public class HotelHabitacion {

    @EmbeddedId
    private HotelHabitacionPK pk;

    public HotelHabitacion()
    {;}

    public HotelHabitacion(Hotel id_hotel, Habitacion id_habitacion) 
    {
        this.pk = new HotelHabitacionPK(id_hotel, id_habitacion);
    }

    public HotelHabitacionPK getPk() {
        return pk;
    }

    public void setPk(HotelHabitacionPK pk) {
        this.pk = pk;
    }
    
    
}
