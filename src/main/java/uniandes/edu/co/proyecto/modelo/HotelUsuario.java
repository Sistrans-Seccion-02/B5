package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotelUsuarios")
public class HotelUsuario {

    @EmbeddedId
    private HotelUsuarioPK pk;

    public HotelUsuario()
    {;}

    public HotelUsuario(Hotel id_hotel, Usuario id_usuario) 
    {
        this.pk = new HotelUsuarioPK(id_hotel, id_usuario);
    }

    public HotelUsuarioPK getPk() {
        return pk;
    }

    public void setPk(HotelUsuarioPK pk) {
        this.pk = pk;
    }

    
    
    
    
    
}
