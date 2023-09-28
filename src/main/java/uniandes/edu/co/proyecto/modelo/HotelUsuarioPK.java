package uniandes.edu.co.proyecto.modelo;


import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class HotelUsuarioPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="id_hotel",referencedColumnName = "id")
    private Hotel id_hotel;
    @ManyToOne
    @JoinColumn(name="id_usuario",referencedColumnName = "id")
    private Usuario id_usuario;

    public HotelUsuarioPK(Hotel id_hotel, Usuario id_usuario) {
        super();
        this.id_hotel = id_hotel;
        this.id_usuario = id_usuario;
    }

    public Hotel getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(Hotel id_hotel) {
        this.id_hotel = id_hotel;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    

}
