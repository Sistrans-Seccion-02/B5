package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservasServicios")
public class ReservasServicios {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer numReserva;

    private Date fecha;
    private Boolean atendida;

    public ReservasServicios(Date fecha, Boolean atendida)
    {
        this.fecha = fecha;
        this.atendida = atendida;
    }

    public ReservasServicios()
    {;}

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

    


    
}
