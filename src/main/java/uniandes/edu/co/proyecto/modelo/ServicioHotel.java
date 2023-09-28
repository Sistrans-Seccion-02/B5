package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "serviciosHotel")
public class ServicioHotel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private Date horarioEntrada;
    private Date horarioSalida;
    private Integer costo;

    public ServicioHotel(Date horarioEntrada, Date horarioSalida, Integer costo)
    {
        this.horarioEntrada = horarioEntrada;
        this.horarioSalida = horarioSalida;
        this.costo = costo;
    }

    public ServicioHotel()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(Date horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public Date getHorarioSalida() {
        return horarioSalida;
    }

    public void setHorarioSalida(Date horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }
    
    
    
}
